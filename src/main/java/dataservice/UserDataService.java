package dataservice;

import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class UserDataService {
    JeeRepository repository;

    public UserDataService() {
        this.repository = new JeeRepository();
    }
}
