package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    @Id
    private String id;
    @Column
    private String nom;
    @Column
    private String password;
    @Column
    private String description;

    public User() { super(); }
    public User(String id, String nom, String password, String description){
        super();
        this.id = id;
        this.nom = nom;
        this.password = password;
        this.description = description;
    }

    public String getId() { return id; }

    public String getNom() { return nom; }

    public String getPassword() { return password; }

    public String getDescription() { return description; }

    public void setId(String id) { this.id = id; }

    public void setNom(String nom) { this.nom = nom; }

    public void setPassword(String password) { this.password = password; }

    public void setDescription(String description) { this.description = description; }
}
