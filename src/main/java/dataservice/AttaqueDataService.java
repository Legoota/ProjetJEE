package dataservice;

import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class AttaqueDataService {
    JeeRepository repository;

    public AttaqueDataService() {
        this.repository = new JeeRepository();
    }



}
