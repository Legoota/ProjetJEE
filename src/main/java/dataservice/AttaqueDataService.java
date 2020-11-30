package dataservice;

import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Classe DataService pour les fonctionnalités liées aux <i>Attaques</i>
 */
@Stateless
@LocalBean
public class AttaqueDataService {

    JeeRepository repository;

    /**
     * Constructeur de la classe AttaqueDataService
     */
    public AttaqueDataService() {
        this.repository = new JeeRepository();
    }



}
