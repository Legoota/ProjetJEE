package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe représentant un <i>Polymon</i>
 */
@Entity
public class Polymon implements Serializable {
    /**
     * L'identifiant du <i>Polymon</i>
     */
    @Id
    private String id;
    /**
     * Le nom du <i>Polymon</i>
     */
    @Column
    private String nom;
    /**
     * La description du <i>Polymon</i>
     */
    @Column
    private String description;
    /**
     * Le nombre de points de vie du <i>Polymon</i>
     */
    @Column
    private int pv;

    /**
     * Constructeur générique d'un <i>Polymon</i>
     */
    public Polymon() { super(); }

    /**
     * Constructeur d'un <i>Polymon</i>
     * @param id L'ID du <i>Polymon</i>
     * @param nom Le nom du <i>Polymon</i>
     * @param description La description du <i>Polymon</i>
     * @param pv Le nombre de PV du <i>Polymon</i>
     */
    public Polymon(String id, String nom, String description, int pv){
        super();
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.pv = pv;
    }

    /**
     * Getteur de l'ID du <i>Polymon</i>
     * @return L'ID du <i>Polymon</i>
     */
    public String getId() { return id; }

    /**
     * Getteur du nom du <i>Polymon</i>
     * @return Le nom du <i>Polymon</i>
     */
    public String getNom() { return nom; }

    /**
     * Getteur de la description du <i>Polymon</i>
     * @return La description du <i>Polymon</i>
     */
    public String getDescription() { return description; }

    /**
     * Getteur du nombre de PV du <i>Polymon</i>
     * @return Le nombre de PV du <i>Polymon</i>
     */
    public int getPV() { return pv; }

    /**
     * Setteur de l'ID du <i>Polymon</i>
     * @param id l'ID du <i>Polymon</i>
     */
    public void setId(String id) { this.id = id; }

    /**
     * Setteur du nom du <i>Polymon</i>
     * @param n Le nom du <i>Polymon</i>
     */
    public void setNom(String n) { this.nom = n; }

    /**
     * Setteur de la description du <i>Polymon</i>
     * @param d La description du <i>Polymon</i>
     */
    public void setDescription(String d) { this.description = d; }

    /**
     * Setteur du nombre de PV du <i>Polymon</i>
     * @param pv Le nombre de PV du <i>Polymon</i>
     */
    public void setPV(int pv) { this.pv = pv; }
}
