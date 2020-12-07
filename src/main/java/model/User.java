package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Classe représentant un joueur
 */
@Entity
public class User implements Serializable {
    @Id
    private String id;
    @Column
    private String prenom;
    @Column
    private String nom;
    @Column
    private String pseudo;
    @Column
    private String password;
    @Column
    private Polymon polymon;
    @Column
    private Parcours parcours;


    public User() {
        super();
    }

    /**
     * Constructeur d'un joueur
     * @param id       L'ID du joueur
     * @param prenom   Le prénom du joueur
     * @param nom      Le nom du joueur
     * @param pseudo   Le pseudo du joueur
     * @param password Le mot de passe du joueur
     */
    public User(String id, String prenom, String nom, String pseudo, String password) {
        super();
        this.id = id;
        this.nom = nom;
        this.pseudo = pseudo;
        this.password = password;
        this.prenom = prenom;
        this.polymon = null;
        this.parcours = null;
    }

    /**
     * Getteur de l'ID du joueur
     * @return L'ID du joueur
     */
    public String getId() {
        return id;
    }

    /**
     * Getteur du nom du joueur
     * @return Le nom du joueur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getteur du mot de passe du joueur
     * @return Le mot de passe du joueur
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getteur du prénom du joueur
     * @return Le prénom du joueur
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Getteur du pseudo du joueur
     * @return Le pseudo di joueur
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Getteur du <i>Polymon</i> du joueur
     * @return Le <i>Polymon</i> du joueur
     */
    public Polymon getPolymon() {
        return polymon;
    }

    /**
     * Getteur du parcours du joueur
     * @return Le parcours du joueur
     */
    public Parcours getParcours() { return parcours; }

    /**
     * Setteur de l'ID du joueur
     * @param id L'ID du joueur
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Setteur du nom du joueur
     * @param nom Le nom du joueur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Setteur du mot de passe du joueur
     * @param password Le mot de passe du joueur
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Setteur du prénom du joueur
     * @param prenom Le prénom du joueur
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Setteur du pseudo du joueur
     * @param pseudo Le pseudo du joueur
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Setteur du <i>Polymon</i> du joueur
     * @param polymon Le <i>Polymon</i> du joueur
     */
    public void setPolymon(Polymon polymon) { this.polymon = polymon; }

    /**
     * Setteur du parcours du joueur
     * @param parcours Le parcours du joueur
     */
    public void setParcours(Parcours parcours) { this.parcours = parcours; }
}
