package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
     * L'identifiant du <i>Polymon</i>
     */
    @Column
    private String ident;
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
     * La liste des attaques du <i>Polymon</i>
     */
    @ElementCollection
    private List<Attaque> attaques;

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
     * @param attaques La liste des attaques du <i>Polymon</i>
     */
    public Polymon(String id, String nom, String description, int pv, List<Attaque> attaques){
        super();
        this.id = id;
        this.ident = id;
        this.nom = nom;
        this.description = description;
        this.pv = pv;
        this.attaques = new ArrayList<>();
        this.attaques = attaques;
    }

    /**
     * Getteur de l'ID du <i>Polymon</i>
     * @return L'ID du <i>Polymon</i>
     */
    public String getId() { return id; }

    /**
     * Getteur de l'Ident du <i>Polymon</i>
     * @return L'Ident du <i>Polymon</i>
     */
    public String getIdent() { return ident; }

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
     * Getteur de la liste des attaques du <i>Polymon</i>
     * @return La liste des attaques du <i>Polymon</i>
     */
    public List<Attaque> getAttaques() { return attaques; }

    /**
     * Setteur de l'ID du <i>Polymon</i>
     * @param id l'ID du <i>Polymon</i>
     */
    public void setId(String id) { this.id = id; }

    /**
     * Setteur de l'Ident du <i>Polymon</i>
     * @param ident l'Ident du <i>Polymon</i>
     */
    public void setIdent(String ident) { this.ident = ident; }

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

    /**
     * Setteur de la liste des attaques du <i>Polymon</i>
     * @param attaques La liste d'attaques du <i>Polymon</i>
     */
    public void setAttaques(List<Attaque> attaques) { this.attaques = attaques; }
}
