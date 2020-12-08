package dataservice;

import model.Polymon;
import model.Step;
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

    /**
     * Gestion de l'accès au repository
     */
    JeeRepository repository;

    /**
     * Constructeur de la classe ParcoursDataService
     */
    public ParcoursDataService() {
        this.repository = new JeeRepository();
    }

    /**
     * Méthode permettant de récupérer une liste des <i>Polymons</i> présents dans une <i>Step</i> du parcours
     * @param stepIdent L'ident de la <i>Step</i>
     * @return La liste de <i>Polymon</i>
     */
    public List<Polymon> getAllPolymonByStep(String stepIdent) { return repository.getPolymonsByStepIdent(stepIdent);}

    /**
     * Méthode permettant de récupérer la description pour un <i>Parcours</i>
     * @param nom Le nom du <i>Parcours</i>
     * @return La description du <i>Parcours</i>
     */
    public String getDescriptionForParcours(String nom) { return repository.getDescriptionForParcours(nom); }

    /**
     * Méthode permettant d'obtenir la <i>Step</i> a partir de son ident
     * @param ident L'ident de la <i>Step</i> a obtenir
     * @return La <i>Step</i>
     */
    public Step getStepFromIdent(String ident) { return repository.getStepByIdent(ident); }

    /**
     * Méthode permettant de récupérer une liste des noms de tous les <i>Parcours</i> disponibles
     * @return Une liste des noms des <i>Parcours</i>
     */
    public List<String> getAllNomFromParcours(){
        return repository.getAllNomFromParcours();
    }
}
