package repository;

import model.Attaque;
import model.Polymon;
import model.User;
import net.ravendb.client.documents.session.IDocumentSession;

import java.util.ArrayList;
import java.util.List;

public class JeeRepository {
    public JeeRepository() { }

    public boolean initializeDatabase(List<Polymon> polymons, List<Attaque> attaques) {
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
                for(Polymon polymon : polymons) {
                    session.store(polymon);
                }
                for(Attaque attaque : attaques){
                    session.store(attaque);
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

    public List<String> getAllPseudos() {
        List<String> pseudos = new ArrayList<>();

        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()){
            pseudos = session.query(User.class).selectFields(String.class,"pseudo").toList();
        } catch(Exception e) {
            System.out.println("Erreur : " + e);
        }

        return pseudos;
    }

    public User getUserFromPseudo(String pseudo) {
        User u = null;
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            u = session.query(User.class).whereEquals("pseudo",pseudo).firstOrDefault();
        } catch(Exception e) {
            System.out.println("Erreur : " + e);
        }
        return u;
    }

    public boolean addUser(User u){
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            session.store(u);
            session.saveChanges();
        }
        catch(Exception e) {
            System.out.println("Erreur : " + e);
            return false;
        }
        return true;
    }
}
