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
    private String prenom;
    @Column
    private String nom;
    @Column
    private String pseudo;
    @Column
    private String password;


    public User() { super(); }
    public User(String id, String prenom, String nom,String pseudo, String password){
        super();
        this.id = id;
        this.nom = nom;
        this.pseudo = pseudo;
        this.password = password;
        this.prenom = prenom;
    }

    public String getId() { return id; }

    public String getNom() { return nom; }

    public String getPassword() { return password; }

    public String getPrenom() { return prenom; }

    public String getPseudo() { return pseudo; }

    public void setId(String id) { this.id = id; }

    public void setNom(String nom) { this.nom = nom; }

    public void setPassword(String password) { this.password = password; }

    public void setPrenom(String prenom) { this.prenom = prenom; }

    public void setPseudo(String pseudo) { this.pseudo = pseudo; }
}
