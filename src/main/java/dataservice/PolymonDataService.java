package dataservice;

import model.Attaque;
import model.Polymon;
import org.apache.commons.codec.binary.Base64;
import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.io.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe DataService pour les fonctionnalités liées aux <i>Polymons</i>
 */
@Stateless
@LocalBean
public class PolymonDataService {

    JeeRepository repository;

    /**
     * Constructeur de la classe PolymonDataService
     */
    public PolymonDataService() {
        this.repository = new JeeRepository();
    }

    /**
     * Méthode permettant de récuperer un Polymon par son nom
     * @param nom Le nom du Polymon
     * @return Le Polymon
     */
    public Polymon getPolymonByNom(String nom){
        return repository.getPolymonByNom(nom);
    }

    public String getImageByNom(String nom) throws IOException {
        //InputStream is = repository.getImageByNom(nom); // InputStream corrompu

        File f = new File("img/"+nom.toLowerCase()+".png");
        InputStream is = new FileInputStream(f);

        byte[] imageBytes = new byte[(int)f.length()];
        is.read(imageBytes, 0, imageBytes.length);
        is.close();
        String imageStr = Base64.encodeBase64String(imageBytes);

        return imageStr;
    }

    public List<Attaque> getAttaquesByNom(String nom) { return getPolymonByNom(nom).getAttaques(); }

    public Polymon getPolymonAdverse(String stepIdent) {
        List<Polymon> polymons = repository.getPolymonsByStepIdent(stepIdent);
        if(polymons == null) return null;
        if(polymons.size() == 1) return polymons.get(0);
        else return polymons.get(ThreadLocalRandom.current().nextInt(0, polymons.size()));
    }

    public Attaque getAttaqueDegatsRandomByNom(String nom) {
        List<Attaque> attaques = getAttaquesByNom(nom);
        if(attaques == null) return null;
        if(attaques.size() == 1) return attaques.get(0);
        else {
            return attaques.get(0);
            //TODO: correct to randomize
            //return attaques.get(ThreadLocalRandom.current().nextInt(0, attaques.size()));
        }
    }
}
