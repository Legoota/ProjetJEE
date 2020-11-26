package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Monstre implements Serializable {
    @Id
    private String id;
    @Column
    private String nom;
    @Column
    private String description;
    @Column
    private int PV;

    public Monstre() { super(); }

    public String getId() { return id; }

    public String getNom() { return nom; }

    public String getDescription() { return description; }

    public int getPV() { return PV; }

    public void setId(String id) { this.id = id; }

    public void setNom(String n) { this.nom = n; }

    public void setDescription(String d) { this.description = d; }

    public void setPV(int pv) { this.PV = pv; }
}
