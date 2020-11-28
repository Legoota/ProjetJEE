package dataservice;

import model.Polymon;
import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Stateless
@LocalBean
public class AdminDataService {

    JeeRepository repository;

    public AdminDataService() {
        this.repository = new JeeRepository();
    }

    public boolean initializeDatabase() {
        List<Polymon> polymons = new ArrayList<>();
        Polymon m = new Polymon("Polymon_1","Morycette","Description de Morycette", 100);
        polymons.add(m);

        return repository.initializeDatabase(polymons);
    }

    public void afficheAllMonstre() {
        List<Polymon> polymons = new ArrayList<>();

        polymons = repository.getAllMonstre();

        for(Polymon polymon : polymons) {
            System.out.println("Le polymon d'id " + polymon.getId() + " s'appelle " + polymon.getNom());
        }
    }
}
