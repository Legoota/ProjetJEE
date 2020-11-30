package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
/**
 * Classe représentant un Polymon
 */
public class Polymon implements Serializable {
    @Id
    private String id;
    @Column
    private String nom;
    @Column
    private String description;
    @Column
    private int pv;

    public Polymon() { super(); }

    /**
     * Constructeur d'un Polymon
     * @param id L'ID du Polymon
     * @param nom Le nom du Polymon
     * @param description La description du Polymon
     * @param pv Le nombre de PV du Polymon
     */
    public Polymon(String id, String nom, String description, int pv){
        super();
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.pv = pv;
    }

    /**
     * Getteur de l'ID du Polymon
     * @return L'ID du Polymon
     */
    public String getId() { return id; }

    /**
     * Getteur du nom du Polymon
     * @return Le nom du Polymon
     */
    public String getNom() { return nom; }

    /**
     * Getteur de la description du Polymon
     * @return La description du Polymon
     */
    public String getDescription() { return description; }

    /**
     * Getteur du nombre de PV du Polymon
     * @return Le nombre de PV du Polymon
     */
    public int getPV() { return pv; }

    /**
     * Setteur de l'ID du Polymon
     * @param id l'ID du Polymon
     */
    public void setId(String id) { this.id = id; }

    /**
     * Setteur du nom du Polymon
     * @param n Le nom du Polymon
     */
    public void setNom(String n) { this.nom = n; }

    /**
     * Setteur de la description du Polymon
     * @param d La description du Polymon
     */
    public void setDescription(String d) { this.description = d; }

    /**
     * Setteur du nombre de PV du Polymon
     * @param pv Le nombre de PV du Polymon
     */
    public void setPV(int pv) { this.pv = pv; }
}
