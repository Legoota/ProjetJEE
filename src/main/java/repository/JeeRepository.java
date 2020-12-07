package repository;

import model.*;
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
     * @param steps Liste de <i>Steps</i> à insérer dans la base de données
     * @param parcours Liste des <i>Parcours</i> à insérer dans la base de données
     * @return <b>True</b> si la base de données a été correctement initialisée, <b>False</b> sinon
     */
    public boolean initializeDatabase(List<Polymon> polymons, List<Attaque> attaques, List<Step> steps, List<Parcours> parcours) throws FileNotFoundException {
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
            for(Step s : steps){
                session.store(s);
            }
            for(Parcours p : parcours){
                session.store(p);
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
     * Méthode permettant de récuperer un <i>Polymon</i> par son nom
     * @param nom Le nom du <i>Polymon</i>
     * @return Le <i>Polymon</i>
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

    /**
     * Méthode permettant de récupérer le <i>Step</i> du parcours par son identifiant
     * @param ident L'identifiant du <i>Step</i>
     * @return Le <i>Step</i>
     */
    public Step getStepByIdent(String ident) {
        Step step = null;

        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            step = session.query(Step.class).whereEquals("ident",ident).firstOrDefault();

        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
        return step;
    }

    /**
     * Méthode permettant de récupérer la liste des <i>Polymons</i> présents dans le <i>Step</i> en cours
     * @param ident L'identifiant du <i>Step</i> en cours
     * @return La liste des <i>Polymons</i> présents dans ce <i>Step</i>
     */
    public List<Polymon> getPolymonsByStepIdent(String ident){
        List<Polymon> polymons = null;
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
             polymons = session.query(Step.class).whereEquals("ident",ident).selectFields(Polymon.class,"polymons").toList();
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
        return polymons;
    }

    /**
     * Méthode permettant de récupérer la liste des <i>Steps</i> suivants en fonction de l'identifiant du <i>Step</i> actuel
     * @param ident L'identifiant du <i>Step</i> actuel
     * @return La liste des <i>Step</i> suivants
     */
    public List<Step> getNextStepByStepIdent(String ident){
        List<Step> steps = null;
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            List<String> nextStepIds = session.query(Step.class).whereEquals("ident",ident).selectFields(String.class, "choixSuivants").toList();
            steps = session.query(Step.class).containsAny("ident",nextStepIds).toList();
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
        return steps;
    }

    /**
     * Méthode permettant d'ajouter un <i>Polymon</i> à un joueur
     * @param user Le joueur auquel on souhaite ajouter un <i>Polymon</i>
     * @param polymon Le <i>Polymon</i> à ajouter
     * @return <i>true</i> si le <i>Polymon</i> à été ajouté, <i>false</i> sinon
     */
    public boolean addPolymonToUser(String user, Polymon polymon){
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            User u = session.query(User.class).whereEquals("pseudo",user).firstOrDefault();
            u.setPolymon(polymon);
            session.saveChanges();
            return true;
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
        return false;
    }

    /**
     * Méthode permettant de récupérer le <i>Polymon</i> du joueur
     * @param user Le joueur auquel on souahite récupérer le <i>Polymon</i>
     * @return Le <i>Polymon</i> du joueur
     */
    public Polymon getPolymonFromUser(String user){
        Polymon p = null;
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            User u = session.query(User.class).whereEquals("pseudo",user).firstOrDefault();
            return u.getPolymon();

        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
        return p;
    }

    /**
     *
     * @param pseudo
     * @return
     */
    public Parcours getParcoursFromUser(String pseudo){
        User u = null;
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            u = session.query(User.class).whereEquals("pseudo",pseudo).firstOrDefault();
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
        return u.getParcours();
    }

    /**
     * Permet de définir un <i>Parcours</i> en cours pour un user
     * @param user Le user a qui ajouter le <i>Parcours</i>
     * @param parcours Le nom du <i>Parcours</i> à ajouter
     * @return <b>True</b> si le parcours a bien été ajouté, <b>False</b> sinon
     */
    public boolean setParcoursToUser(String user, String parcours){
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            User u = session.query(User.class).whereEquals("pseudo",user).firstOrDefault();
            Parcours p = session.query(Parcours.class).whereEquals("ident",parcours).firstOrDefault();
            u.setParcours(p);
            session.saveChanges();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @return
     */
    public List<String> getAllNomFromParcours(){
        List<String> parcours = null;
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()){
            parcours = session.query(Parcours.class).selectFields(String.class,"nom").toList();
        } catch(Exception e) {
            System.out.println("Erreur : " + e);
        }
        return parcours;
    }

    public String getIdentParcoursByNom(String nom){
        String ident = null;
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()){
            ident = session.query(Parcours.class).whereEquals("nom",nom).selectFields(String.class,"ident").toString();
        } catch(Exception e) {
            System.out.println("Erreur : " + e);
        }
        return ident;
    }

    public String getDescriptionForParcours(String nom) {
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()){
            Parcours p = session.query(Parcours.class).whereEquals("nom",nom).firstOrDefault();
            if(p != null) return p.getDescription();
        } catch(Exception e) {
            System.out.println("Erreur : " + e);
        }
        return "Description du parcours";
    }

    public boolean storeNewPolymonFromUserStep(String pseudo, List<Polymon> polymons) {
        boolean res = false;
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()){
            Step s = session.query(User.class).whereEquals("pseudo",pseudo).selectFields(Parcours.class,"parcours").selectFields(Step.class,"choixCourant").firstOrDefault();
            s.setPolymons(polymons);
            session.saveChanges();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
