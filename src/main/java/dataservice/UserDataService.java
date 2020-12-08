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
     * Méthode permettant d'ajouter un parcours à l'utilisateur
     * @param user Le pseudo du <i>User</i>
     * @param parcours L'ident du <i>Parcours</i>
     * @return <b>True</b> si le <i>Parcours</i> est bien ajouté, <b>False</b> sinon
     */
    public boolean addParcoursToUser(String user, String parcours) { return repository.setParcoursToUser(user,parcours); }

    /**
     * Méthode permettant de récupérer le parcours d'un <i>User</i>
     * @param pseudo Le pseudo du <i>User</i>
     * @return Le <i>Parcours</i> du <i>User</i>
     */
    public Parcours getParcoursFromUser(String pseudo){
        return repository.getParcoursFromUser(pseudo);
    }

    /**
     * Méthode permettant de récupérer un <i>Polymon</i> a partir du pseudo d'un <i>User</i>
     * @param pseudo Le pseudo d'un <i>User</i>
     * @return Le <i>Polymon</i> du <i>User</i>
     */
    public Polymon getPolymonFromUser(String pseudo){
        return repository.getPolymonFromUser(pseudo);
    }

    /**
     * Méthode permettant de récupérer le <i>Polymon</i> adverse
     * Si plusieurs <i>Polymon sont disponible, la liste est réduite a un adversaire</i>
     * @param pseudo Le pseudo du <i>User</i>
     * @return Le <i>Polymon</i> adverse
     */
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

    /**
     * Méthode permettant de récupérer la vie totale du <i>Polymon</i> adverse
     * @param pseudo Le pseudo du <i>User</i>
     * @return Les PV totaux du <i>Polymon</i>
     */
    public int getPolymonAdverseTotalLifeFromUser(String pseudo) {
        Polymon adv = getPolymonAdverseFromUser(pseudo);
        return repository.getPolymonByNom(adv.getNom()).getPV();
    }

    /**
     * Méthode permettant de récupérer le pourcentage de vie d'un <i>Polymon</i>
     * @param nomPolymon Le nom du <i>Polymon</i>
     * @param pvCourant Les PV du <i>Polymon</i>
     * @return La valeur entre 0 et 100
     */
    public int getCurrentPourcentagePolymonLife(String nomPolymon, int pvCourant){
        int defaut = repository.getPolymonByNom(nomPolymon).getPV();
        return pvCourant*100/defaut;
    }

    /**
     * Méthode permettant de récupérer la <i>Step</i> courante
     * @param pseudo Le pseudo du <i>User</i>
     * @return La <i>Step</i>
     */
    public Step getCurrentStep(String pseudo) {
        Parcours user_parcours = repository.getParcoursFromUser(pseudo);
        if(user_parcours == null) return null;
        return user_parcours.getChoixCourant();
    }

    /**
     * Méthode permettant de récupérer la liste des <i>Steps</i> suivantes
     * @param pseudo Le pseudo du <i>User</i>
     * @return La liste des ident des <i>Steps</i> suivantes
     */
    public List<String> getNextStepNameByStepIdent(String pseudo) {
        return repository.getNextStepByStepIdent(getCurrentStep(pseudo).getIdent());
    }

    /**
     * Méthode permettant de récupérer une <i>Step</i> a partir de son ident
     * @param stepIdent L'ident
     * @return La <i>Step</i>
     */
    public Step getStepFromStepIdent(String stepIdent) {
        return repository.getStepByIdent(stepIdent);
    }

    /**
     * Méthode permettant de restaurer la vie du <i>Polymon</i> du <i>User</i>
     * @param pseudo Le pseudo du <i>User</i>
     * @param increment Valeur supplémentaire a ajouter à la vie du <i>Polymon</i>
     * @return <b>True</b> si le changement a été correctement effectué, <b>False</b> sinon
     */
    public boolean restorePolymonLife(String pseudo, int increment) {
        Polymon p = repository.getPolymonByNom(repository.getPolymonFromUser(pseudo).getNom());
        return repository.setPolymonUserPv(pseudo, p.getPV()+increment);
    }

    /**
     * Méthode permettant de récupérer le numéro de l'<i>Attaque</i> dans la liste des <i>Attaques</i> depuis son Nom
     * @param pseudo Le pseudo du <i>User</i>
     * @param nomAttaque Le nom de l'<i>Attaque</i>
     * @return Le numéro de l'<i>Attaque</i>
     */
    public int numeroAttaque(String pseudo, String nomAttaque) {
        Polymon courant = getPolymonFromUser(pseudo);
        int res = 0;
        for(Attaque a : courant.getAttaques()) {
            if(nomAttaque.equals(a.getNom())) return res;
            res++;
        }
        return res;
    }

    /**
     * Méthode permettant de récupérer le numéro de la <i>Step</i> dans la liste depuis son ident
     * @param pseudo Le pseudo du <i>User</i>
     * @param stepIdent L'ident de la <i>Step</i>
     * @return Le numéro dans la liste de la <i>Step</i>
     */
    public int numeroStepIdent(String pseudo, String stepIdent) {
        int res = 0;
        for(String stepIdents: getNextStepNameByStepIdent(pseudo)) {
            if(stepIdent.equals(stepIdents)) return res;
            res++;
        }
        return res;
    }

    /**
     * Méthode réalisant le changement de la <i>Step</i> courante du <i>User</i>
     * @param pseudo Le pseudo du <i>User</i>
     * @param stepIdent L'identifiant de la <i>Step</i> qui va être mis en place
     * @return <b>True</b> si le changement est correctement réalisé, <b>False</b> sinon
     */
    public boolean changeStepForUser(String pseudo, String stepIdent) {
        return repository.changeStepForUser(pseudo, stepIdent);
    }

    /**
     * Méthode permettant de frapper le <i>Polymon</i> adverse
     * @param pseudo Le pseudo du <i>User</i>
     * @param degats Le nombre de PV a enlever
     * @return <b>True</b> si le changement a bien été effectué, <b>False</b> sinon
     */
    public boolean hitPolymonAdverseFromUser(String pseudo, int degats) {
        Polymon adverse = getPolymonAdverseFromUser(pseudo);
        boolean res;
        if(adverse.getPV() - degats <= 0) {
            res = true;
            repository.setPolymonAdversePv(pseudo,0);
        }
        else {
            res = false;
            repository.setPolymonAdversePv(pseudo, adverse.getPV() - degats);
        }
        return res;
    }

    /**
     * Méthode permettant de se faire toucher par une <i>Attaque</i>
     * @param pseudo Le pseudo du <i>User</i>
     * @param degats Le nombre de PV a enlever
     * @return <b>True</b> si l'opération a été correctement effectuée, <b>False</b> sinon
     */
    public boolean hitPolymonFromAdversaire(String pseudo, int degats) {
        Polymon courant = getPolymonFromUser(pseudo);
        if(courant.getPV() - degats <= 0) {
            repository.setPolymonUserPv(pseudo, 0);
            return true;
        }
        else {
            repository.setPolymonUserPv(pseudo, courant.getPV() - degats);
            return false;
        }
    }

    /**
     * Méthode permettant de se faire attaquer par un <i>Polymon</i> adverse
     * @param pseudo Le pseudo du <i>User</i>
     * @return L'<i>Attaque</i> adverse
     */
    public Attaque getAttacked(String pseudo) {
        Polymon ennemi = getPolymonAdverseFromUser(pseudo);
        return ennemi.getAttaques().get(ThreadLocalRandom.current().nextInt(0, ennemi.getAttaques().size()));
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
