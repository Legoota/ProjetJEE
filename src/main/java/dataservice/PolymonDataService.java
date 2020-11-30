package dataservice;

import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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
}
