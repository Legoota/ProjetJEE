package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
/**
 * Classe attaque représentant les attaques des Polymons
 */
public class Attaque implements Serializable {
    @Id
    private String id;
    @Column
    private String nom;
    @Column
    private int degats;

    public Attaque(){super();}

    /**
     * Constructeur d'une attaque
     * @param id L'ID de l'attaque
     * @param nom Le nom de l'attaque
     * @param degats Les dégats infligés pas l'attaque
     */
    public Attaque(String id, String nom, int degats){
        super();
        this.id = id;
        this.nom = nom;
        this.degats = degats;
    }

    /**
     * Getteur de l'ID de l'attaque
     * @return L'ID de l'attaque
     */
    public String getId() { return id; }

    /**
     * Getteur du nom de l'attaque
     * @return Le nom de l'attaque
     */
    public String getNom() { return nom; }

    /**
     * Getteur des dégats infligés par l'attaque
     * @return Les dégats de l'attaque
     */
    public int getDegats() { return degats; }

    /**
     * Setteur de l'ID de l'attaque
     * @param id L'ID de l'attaque
     */
    public void setId(String id) { this.id = id; }

    /**
     * Setteur du nom de l'attaque
     * @param nom Le nom de l'attaque
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Setteur des dégats de l'attaque
     * @param degats Les dégats de l'attaque
     */
    public void setDegats(int degats) { this.degats = degats; }
}
