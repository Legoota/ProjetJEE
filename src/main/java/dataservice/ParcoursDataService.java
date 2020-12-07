package dataservice;

import model.Polymon;
import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Classe DataService pour les fonctionnalités liées au <i>Parcours</i>
 */
@Stateless
@LocalBean
public class ParcoursDataService {

    JeeRepository repository;

    /**
     * Constructeur de la classe ParcoursDataService
     */
    public ParcoursDataService() {
        this.repository = new JeeRepository();
    }

    /**
     * Méthode permettant de récupérer une liste des noms de tous les <i>Parcours</i> disponibles
     * @return Une liste des noms des <i>Parcours</i>
     */
    public List<String> getAllNomFromParcours(){
        return repository.getAllNomFromParcours();
    }

    /**
     * Méthode permettant de récupérer une liste des <i>Polymons</i> présents dans une <i>Step</i> du parcours
     * @param stepIdent L'ident de la <i>Step</i>
     * @return La liste de <i>Polymon</i>
     */
    public List<Polymon> getAllPolymonByStep(String stepIdent) { return repository.getPolymonByStep(stepIdent);}

    /**
     * Méthode permettant de récupérer la description pour un <i>Parcours</i>>
     * @param nom Le nom du <i>Parcours</i>
     * @return La description du <i>Parcours</i>
     */
    public String getDescriptionForParcours(String nom) { return repository.getDescriptionForParcours(nom); }
}
