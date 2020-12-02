package repository;

import model.Attaque;
import model.Polymon;
import model.User;
import net.ravendb.client.documents.operations.attachments.CloseableAttachmentResult;
import net.ravendb.client.documents.session.IDocumentSession;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
    public boolean initializeDatabase(List<Polymon> polymons, List<Attaque> attaques) throws FileNotFoundException {
        FileInputStream bulbizarre_i = new FileInputStream("img/bulbizarre.png");
        FileInputStream salameche_i = new FileInputStream("img/salameche.png");
        FileInputStream carapuce_i = new FileInputStream("img/carapuce.png");
        FileInputStream pikachu_i = new FileInputStream("img/pikachu.png");
        FileInputStream goupix_i = new FileInputStream("img/goupix.png");
        FileInputStream nosferapti_i = new FileInputStream("img/nosferapti.png");
        FileInputStream miaouss_i = new FileInputStream("img/miaouss.png");
        FileInputStream psykokwak_i = new FileInputStream("img/psykokwak.png");
        FileInputStream noeunoeuf_i = new FileInputStream("img/noeunoeuf.png");
        FileInputStream insecateur_i = new FileInputStream("img/insecateur.png");
        FileInputStream scarabrute_i = new FileInputStream("img/scarabrute.png");
        FileInputStream magmar_i = new FileInputStream("img/magmar.png");
        FileInputStream leviator_i = new FileInputStream("img/leviator.png");
        FileInputStream ptera_i = new FileInputStream("img/ptera.png");
        FileInputStream dracolosse_i = new FileInputStream("img/dracolosse.png");
        FileInputStream rhinoferos_i = new FileInputStream("img/rhinoferos.png");
        FileInputStream aquali_i = new FileInputStream("img/aquali.png");
        FileInputStream sulfura_i = new FileInputStream("img/sulfura.png");
        FileInputStream mew_i = new FileInputStream("img/mew.png");
        FileInputStream mewtwo_i = new FileInputStream("img/mewtwo.png");

        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            for(Polymon polymon : polymons) {
                session.store(polymon);
            }
            for(Attaque attaque : attaques){
                session.store(attaque);
            }

            session.advanced().attachments().store("Polymon_1", "bulbizarre.png", bulbizarre_i, "image/png");
            session.advanced().attachments().store("Polymon_2", "salameche.png", salameche_i, "image/png");
            session.advanced().attachments().store("Polymon_3", "carapuce.png", carapuce_i, "image/png");
            session.advanced().attachments().store("Polymon_4", "pikachu.png", pikachu_i, "image/png");
            session.advanced().attachments().store("Polymon_5", "goupix.png", goupix_i, "image/png");
            session.advanced().attachments().store("Polymon_6", "nosferapti.png", nosferapti_i, "image/png");
            session.advanced().attachments().store("Polymon_7", "miaouss.png", miaouss_i, "image/png");
            session.advanced().attachments().store("Polymon_8", "psykokwak.png", psykokwak_i, "image/png");
            session.advanced().attachments().store("Polymon_9", "noeunoeuf.png", noeunoeuf_i, "image/png");
            session.advanced().attachments().store("Polymon_10", "insecateur.png", insecateur_i, "image/png");
            session.advanced().attachments().store("Polymon_11", "scarabrute.png", scarabrute_i, "image/png");
            session.advanced().attachments().store("Polymon_12", "magmar.png", magmar_i, "image/png");
            session.advanced().attachments().store("Polymon_13", "leviator.png", leviator_i, "image/png");
            session.advanced().attachments().store("Polymon_14", "ptera.png", ptera_i, "image/png");
            session.advanced().attachments().store("Polymon_15", "dracolosse.png", dracolosse_i, "image/png");
            session.advanced().attachments().store("Polymon_16", "rhinoferos.png", rhinoferos_i, "image/png");
            session.advanced().attachments().store("Polymon_17", "aquali.png", aquali_i, "image/png");
            session.advanced().attachments().store("Polymon_18", "sulfura.png", sulfura_i, "image/png");
            session.advanced().attachments().store("Polymon_19", "mew.png", mew_i, "image/png");
            session.advanced().attachments().store("Polymon_20", "mewtwo.png", mewtwo_i, "image/png");

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

    /**
     * Méthode permettant de récuperer un Polymon par son nom
     * @param nom Le nom du Polymon
     * @return Le Polymon
     */
    public Polymon getPolymonByNom(String nom){
        Polymon p = null;
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            p = session.query(Polymon.class).whereEquals("nom", nom).firstOrDefault();
        } catch(Exception e) {
            System.out.println("Erreur : " + e);
        }
        return p;
    }

    public InputStream getImageByNom(String nom) {
        InputStream is = null;

        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            Polymon p = session.query(Polymon.class).whereEquals("nom",nom).firstOrDefault();

            try (CloseableAttachmentResult image = session.advanced().attachments().get(p, p.getNom().toLowerCase()+".png")) {
                is = image.getData();
            }

        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }

        return is;
    }
}
