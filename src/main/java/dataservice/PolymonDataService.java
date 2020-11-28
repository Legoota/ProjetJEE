package dataservice;

import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class PolymonDataService {
    JeeRepository repository;

    public PolymonDataService() {
        this.repository = new JeeRepository();
    }
}
