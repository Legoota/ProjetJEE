package repository;

import model.Monstre;
import net.ravendb.client.documents.session.IDocumentSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class JeeRepository {
    public JeeRepository() { }

    public boolean initializeDatabase(Vector<Monstre> monstres) {
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
                for(Monstre monstre : monstres) {
                    session.store(monstre);
                }
                session.saveChanges();
        }
        catch(Exception e) {
            System.out.println("Erreur : " + e);
            return false;
        }
        return true;
    }

    public List<Monstre> getAllMonstre() {
        List<Monstre> monstres = new ArrayList<>();

        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()){
            monstres = session.query(Monstre.class).toList();
        } catch(Exception e) {
            System.out.println("Erreur : " + e);
        }

        return monstres;
    }
}
