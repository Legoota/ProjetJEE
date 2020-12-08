package dataservice;

import model.*;
import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe DataService pour les fonctionnalités liées aux <i>Users</i>
 */
@Stateless
@LocalBean
public class UserDataService {

    JeeRepository repository;

    /**
     * Constructeur de la classe UserDataService
     */
    public UserDataService() {
        this.repository = new JeeRepository();
    }

    /**
     * Méthode permettant de créer un <i>User</i>
     * @param prenom Prénom du <i>User</i>
     * @param nom Nom du <i>User</i>
     * @param pseudo Pseudo du <i>User</i>
     * @param password Mot de passe du <i>User</i>
     * @return <b>True</b> si le <i>User</i> a correctement été créé, <b>False</b> sinon
     */
    public boolean createUser(String prenom, String nom, String pseudo, String password){
        List<String> currentPseudos = repository.getAllPseudos();
        for(String p : currentPseudos){
            if(pseudo.equals(p))return false;
        }
        User u = new User("User_"+currentPseudos.size(), prenom, nom, pseudo, getMd5(password));
        return repository.addUser(u);
    }

    /**
     * Méthode permettant d'authentifier un <i>User</i>
     * @param pseudo Pseudo du <i>User</i>
     * @param password Mot de passe du du <i>User</i>
     * @return <b>True</b> si le <i>User</i> a correctement été authentifié, <b>False</b> sinon
     */
    public User loginUser(String pseudo, String password) {
        User u = repository.getUserFromPseudo(pseudo);
        if(u == null) return null;
        if(u.getPassword().equals(getMd5(password))) return u;
        return null;
    }

    /**
     * Méthode permettant d'ajouter un <i>Polymon</i> à un joueur
     * @param user Le joueur auquel on souhaite ajouter un <i>Polymon</i>
     * @param polymon Le <i>Polymon</i> à ajouter au joueur
     * @return <i>true</i> si le <i>Polymon</i> à été ajouté, <i>false</i> sinon
     */
    public boolean addPolymonToUser(String user, Polymon polymon){
        return repository.addPolymonToUser(user,polymon);
    }

    /**
     *
     * @param user
     * @param parcours
     * @return
     */
    public boolean addParcoursToUser(String user, String parcours) { return repository.setParcoursToUser(user,parcours); }

    /**
     *
     * @param pseudo
     * @return
     */
    public Parcours getParcoursFromUser(String pseudo){
        return repository.getParcoursFromUser(pseudo);
    }

    /**
     *
     * @param pseudo
     * @return
     */
    public Polymon getPolymonFromUser(String pseudo){
        return repository.getPolymonFromUser(pseudo);
    }

    public Polymon getPolymonAdverseFromUser(String pseudo) {
        List<Polymon> polymons = repository.getParcoursFromUser(pseudo).getChoixCourant().getPolymons();
        if(polymons == null) return null;
        if(polymons.size() == 1) return polymons.get(0);
        else {
            polymons.remove(ThreadLocalRandom.current().nextInt(0, polymons.size()));
            repository.storeNewPolymonFromUserStep(pseudo, polymons);
            //TODO: correct error: parcours retourne null

            return polymons.get(0);
        }
    }

    public int getPolymonAdverseTotalLifeFromUser(String pseudo) {
        Polymon adv = getPolymonAdverseFromUser(pseudo);
        return repository.getPolymonByNom(adv.getNom()).getPV();
    }

    public int getCurrentPourcentagePolymonLife(String nomPolymon, int pvCourant){
        int defaut = repository.getPolymonByNom(nomPolymon).getPV();
        return pvCourant*100/defaut;
    }

    /**
     *
     * @param pseudo
     * @return
     */
    public Step getCurrentStep(String pseudo) {
        Parcours user_parcours = repository.getParcoursFromUser(pseudo);
        if(user_parcours == null) return null;
        return user_parcours.getChoixCourant();
    }

    public List<String> getNextStepNameByStepIdent(String pseudo) {
        return repository.getNextStepByStepIdent(getCurrentStep(pseudo).getIdent());
    }

    public Step getStepFromStepIdent(String stepIdent) {
        return repository.getStepByIdent(stepIdent);
    }

    public boolean restorePolymonLife(String pseudo, int increment) {
        Polymon p = repository.getPolymonByNom(repository.getPolymonFromUser(pseudo).getNom());
        return repository.setPolymonUserPv(pseudo, p.getPV()+increment);
    }

    public int numeroAttaque(String pseudo, String nomAttaque) {
        Polymon courant = getPolymonFromUser(pseudo);
        int res = 0;
        for(Attaque a : courant.getAttaques()) {
            if(nomAttaque.equals(a.getNom())) return res;
            res++;
        }
        return res;
    }

    public int numeroStepIdent(String pseudo, String stepIdent) {
        int res = 0;
        for(String stepIdents: getNextStepNameByStepIdent(pseudo)) {
            if(stepIdent.equals(stepIdents)) return res;
            res++;
        }
        return res;
    }

    public boolean changeStepForUser(String pseudo, String stepIdent) {
        return repository.changeStepForUser(pseudo, stepIdent);
    }

    public boolean hitPolymonAdverseFromUser(String pseudo, int degats) {
        Polymon adverse = getPolymonAdverseFromUser(pseudo);
        boolean res;
        if(adverse.getPV() - degats < 0) {
            res = true;
            repository.setPolymonAdversePv(pseudo,0);
        }
        else {
            res = false;
            repository.setPolymonAdversePv(pseudo, adverse.getPV() - degats);
        }
        return res;
    }

    public boolean hitPolymonFromAdversaire(String pseudo, int degats) {
        Polymon courant = getPolymonFromUser(pseudo);
        int res = 0;
        if(courant.getPV() - degats <= 0) {
            repository.setPolymonUserPv(pseudo, 0);
            return true;
            //TODO: faire ca
        }
        else {
            repository.setPolymonUserPv(pseudo, courant.getPV() - degats);
            return false;
        }

    }

    /**
     * Méthode de classe réalisant le hash MD5 d'une chaine de charactères
     * @param input Chaine de charactères à hasher
     * @return Hash de la chaine de charactères d'entrée
     */
    public static String getMd5(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
