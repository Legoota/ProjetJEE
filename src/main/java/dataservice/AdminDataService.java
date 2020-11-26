package dataservice;

import model.Monstre;
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
        Vector<Monstre> monstres = new Vector<>();
        Monstre m = new Monstre();
        m.setId("1");
        m.setNom("Test");
        m.setDescription("La description");
        m.setPV(100);
        monstres.add(m);

        return repository.initializeDatabase(monstres);
    }

    public void afficheAllMonstre() {
        List<Monstre> monstres = new ArrayList<>();

        monstres = repository.getAllMonstre();

        for(Monstre monstre : monstres) {
            System.out.println("Le monstre d'id " + monstre.getId() + " s'appelle " + monstre.getNom());
        }
    }
}
