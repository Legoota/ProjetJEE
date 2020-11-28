package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
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

    public Polymon(String id, String nom, String description, int pv){
        super();
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.pv = pv;
    }

    public String getId() { return id; }

    public String getNom() { return nom; }

    public String getDescription() { return description; }

    public int getPV() { return pv; }

    public void setId(String id) { this.id = id; }

    public void setNom(String n) { this.nom = n; }

    public void setDescription(String d) { this.description = d; }

    public void setPV(int pv) { this.pv = pv; }
}
