package repository;

import model.Polymon;
import net.ravendb.client.documents.session.IDocumentSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class JeeRepository {
    public JeeRepository() { }

    public boolean initializeDatabase(List<Polymon> polymons) {
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
                for(Polymon polymon : polymons) {
                    session.store(polymon);
                }
                session.saveChanges();
        }
        catch(Exception e) {
            System.out.println("Erreur : " + e);
            return false;
        }
        return true;
    }

    public List<Polymon> getAllMonstre() {
        List<Polymon> polymons = new ArrayList<>();

        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()){
            polymons = session.query(Polymon.class).toList();
        } catch(Exception e) {
            System.out.println("Erreur : " + e);
        }

        return polymons;
    }
}
