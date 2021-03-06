package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Classe représentant le parcours du joueur
 */
@Entity
public class Parcours implements Serializable {
    /**
     * L'id du parcours
     */
    @Id
    private String id;
    /**
     * L'ident du parcours
     */
    @Column
    private String ident;
    /**
     * Le nom du parcours
     */
    @Column
    private String nom;
    /**
     * La description du parcours
     */
    @Column
    private String description;
    /**
     * L'étape de parcours
     */
    @Column
    private Step choixCourant;

    /**
     * Constructeur par défaut d'un parcours
     */
    public Parcours() { super(); }

    /**
     * Constructeur d'un parcours joueur
     * @param id L'ID du parcours
     * @param nom Le nom du parcours
     * @param description La description du parcours
     * @param premierChoix Le premier choix du parcours
     */
    public Parcours(String id, String nom, String description, Step premierChoix){
        super();
        this.id = id;
        this.ident = id;
        this.nom = nom;
        this.description = description;
        this.choixCourant = premierChoix;
    }

    /**
     * Getteur de l'ID du parcours
     * @return L'ID du parcours
     */
    public String getId() { return id; }

    /**
     * Getteur de l'ident du parcours
     * @return L'ident du parcours
     */
    public String getIdent() { return ident; }

    /**
     * Getteur du nom du parcours
     * @return Le nom du parcours
     */
    public String getNom() { return nom; }

    /**
     * Getteur de la description du parcours
     * @return La description du parcours
     */
    public String getDescription() { return description; }

    /**
     * Getteur de la <i>Step</i> courante du parcours
     * @return La <i>Step</i> courante du parcours
     */
    public Step getChoixCourant() { return choixCourant; }

    /**
     * Setteur de l'ID du parcours
     * @param id L'ID du parcours
     */
    public void setId(String id) { this.id = id; }

    /**
     * Setteur de l'ident du parcours
     * @param ident L'ident du parcours
     */
    public void setIdent(String ident) { this.ident = ident; }

    /**
     * Setteur du nom du parcours
     * @param nom Le nom du parcours
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Setteur de la description du parcours
     * @param description Le description du parcours
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Setteur du choix courant du parcours
     * @param choix La <i>Step</i> courante
     */
    public void setChoixCourant(Step choix) { this.choixCourant = choix; }
}
