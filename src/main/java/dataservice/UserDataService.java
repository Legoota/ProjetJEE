package dataservice;

import model.User;
import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Stateless
@LocalBean
public class UserDataService {
    JeeRepository repository;

    public UserDataService() {
        this.repository = new JeeRepository();
    }

    public boolean createUser(String prenom, String nom, String pseudo, String password){
        List<String> currentPseudos = repository.getAllPseudos();
        for(String p : currentPseudos){
            if(pseudo.equals(p))return false;
        }
        User u = new User("User_"+currentPseudos.size(), prenom, nom, pseudo, getMd5(password));
        return repository.addUser(u);
    }

    public User loginUser(String pseudo, String password) {
        User u = repository.getUserFromPseudo(pseudo);
        if(u == null) return null;
        if(u.getPassword().equals(getMd5(password))) return u;
        return null;
    }

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
