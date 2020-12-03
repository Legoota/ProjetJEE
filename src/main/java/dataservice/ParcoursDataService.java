package dataservice;

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
     *
     * @return
     */
    public List<String> getAllNomFromParcours(){
        return repository.getAllNomFromParcours();
    }
}
