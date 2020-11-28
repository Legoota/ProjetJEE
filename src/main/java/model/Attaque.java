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
    private String description;

    public Attaque(){super();}
    public Attaque(String id, String nom, String description){
        super();
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public String getId() { return id; }

    public String getNom() { return nom; }

    public String getDescription() { return description; }

    public void setId(String id) { this.id = id; }

    public void setNom(String nom) { this.nom = nom; }

    public void setDescription(String description) { this.description = description; }
}
