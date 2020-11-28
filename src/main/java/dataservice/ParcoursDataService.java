package dataservice;

import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ParcoursDataService {
    JeeRepository repository;

    public ParcoursDataService() {
        this.repository = new JeeRepository();
    }
}
