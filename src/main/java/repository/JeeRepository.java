package repository;

import model.Attaque;
import model.Polymon;
import model.User;
import net.ravendb.client.documents.session.IDocumentSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe contenant l'ensemble des méthodes accédant à la base de données
 */
public class JeeRepository {

    /**
     * Constructeur de la classe JeeRepository
     */
    public JeeRepository() { }

    /**
     * Méthode permettant l'initialisation de la base de données
     * @param polymons Liste de <i>Polymons</i> à insérer dans la base de données
     * @param attaques Liste d'<i>Attaques</i> à insérer dans la base de données
     * @return <b>True</b> si la base de données a été correctement initialisée, <b>False</b> sinon
     */
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

    /**
     * Méthode permettant de récupérer tous les Polymons
     * @return Une liste de tous les Polymons
     */
    public List<Polymon> getAllMonstre() {
        List<Polymon> polymons = new ArrayList<>();

        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()){
            polymons = session.query(Polymon.class).toList();
        } catch(Exception e) {
            System.out.println("Erreur : " + e);
        }
        return polymons;
    }

    /**
     * Méthode permettant de récupérer tous les pseudos des joueurs
     * @return La liste des pseudos des joueurs
     */
    public List<String> getAllPseudos() {
        List<String> pseudos = new ArrayList<>();

        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()){
            pseudos = session.query(User.class).selectFields(String.class,"pseudo").toList();
        } catch(Exception e) {
            System.out.println("Erreur : " + e);
        }
        return pseudos;
    }

    /**
     * Méthode permettant de récupérer un joueur par son pseudo
     * @param pseudo Le pseudo du joueur à récupérer
     * @return Le joueur
     */
    public User getUserFromPseudo(String pseudo) {
        User u = null;
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            u = session.query(User.class).whereEquals("pseudo",pseudo).firstOrDefault();
        } catch(Exception e) {
            System.out.println("Erreur : " + e);
        }
        return u;
    }

    /**
     * Méthode permettant d'ajouter un joueur
     * @param u Le joueur à ajouter
     * @return <b>True</b> si le joueur à été correctement ajouté, <b>False</b> sinon
     */
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
