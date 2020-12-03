package dataservice;

import model.User;
import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

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

    public boolean addPolymonToUSer(String user, String polymon){
        return repository.addPolymonToUser(user,polymon);
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
