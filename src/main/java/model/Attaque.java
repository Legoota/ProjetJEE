package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Attaque implements Serializable {
    @Id
    private String id;
    @Column
    private String nom;
    @Column
    private int degats;

    public Attaque(){super();}
    public Attaque(String id, String nom, int degats){
        super();
        this.id = id;
        this.nom = nom;
        this.degats = degats;
    }

    public String getId() { return id; }

    public String getNom() { return nom; }

    public int getDegats() { return degats; }

    public void setId(String id) { this.id = id; }

    public void setNom(String nom) { this.nom = nom; }

    public void setDegats(int degats) { this.degats = degats; }
}
