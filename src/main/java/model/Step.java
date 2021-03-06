package model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant de la <i>Step</i>
 */
@Entity
public class Step implements Serializable {
    /**
     * L'identifiant de la <i>Step</i>
     */
    @Id
    private String id;
    /**
     * L'identifiant de la <i>Step</i>
     */
    @Column
    private String ident;
    /**
     * Le nom de la <i>Step</i>
     */
    @Column
    private String nom;
    /**
     * La description de la <i>Step</i>
     */
    @Column
    private String description;
    /**
     * Le type d'environnement de la <i>Step</i>
     */
    @Column
    private String typeEnv;
    /**
     * La liste des <i>Polymons</i> trouvables dans cette Step
     */
    @ElementCollection
    private List<Polymon> polymons;
    /**
     * La liste des propositions de lieux suivants
     */
    @ElementCollection
    private List<String> steps_ids;

    /**
     * Constructeur générique d'une <i>Step</i>
     */
    public Step() { super(); }

    /**
     * Constructeur de la classe <i>Step</i>
     * @param id L'identifiant de la <i>Step</i>
     * @param nom Le nom de la <i>Step</i>
     * @param description La description de la <i>Step</i>
     * @param env L'environnement de la <i>Step</i>
     * @param polymons La liste de <i>Polymons</i> de la <i>Step</i>
     * @param steps_ids La liste des <i>Steps</i> suivantes
     */
    public Step(String id, String nom, String description, String env, List<Polymon> polymons, List<String> steps_ids) {
        super();
        this.id = id;
        this.ident = id;
        this.nom = nom;
        this.description = description;
        this.typeEnv = env;
        this.polymons = new ArrayList<>();
        this.polymons = polymons;
        this.steps_ids = new ArrayList<>();
        this.steps_ids = steps_ids;
    }

    /**
     * Getteur de l'id de la <i>Step</i>
     * @return L'id de la <i>Step</i>
     */
    public String getId() { return id; }

    /**
     * Getteur de l'ident de la <i>Step</i>
     * @return L'ident de la <i>Step</i>
     */
    public String getIdent() { return ident; }

    /**
     * Getteur du nom de la <i>Step</i>
     * @return Le nom de la <i>Step</i>
     */
    public String getNom() { return nom; }

    /**
     * Getteur de la description de la <i>Step</i>
     * @return La description de la <i>Step</i>
     */
    public String getDescription() { return description; }

    /**
     * Getteur du type d'environnement de la <i>Step</i>
     * @return Le type d'environnement de la <i>Step</i>
     */
    public String getTypeEnv() { return typeEnv; }

    /**
     * Getteur de la liste de <i>Polymons</i> de la <i>Step</i>
     * @return La liste de <i>Polymons</i> de la <i>Step</i>
     */
    public List<Polymon> getPolymons() { return polymons; }

    /**
     * Getteur de la liste des <i>Steps</i> suivantes
     * @return La liste des <i>Steps</i> suivantes
     */
    public List<String> getChoixSuivants() { return steps_ids; }

    /**
     * Setteur de l'id de la <i>Step</i>
     * @param id L'id de la <i>Step</i>
     */
    public void setId(String id) { this.id = id; }

    /**
     * Setteur de l'ident de la <i>Step</i>
     * @param ident L'ident de la <i>Step</i>
     */
    public void setIdent(String ident) { this.ident = ident; }

    /**
     * Setteur du nom de la <i>Step</i>
     * @param nom Le nom de la <i>Step</i>
     */
    public void setNom(String nom) { this.nom = nom; }

    /**
     * Setteur de la description de la <i>Step</i>
     * @param description La description de la <i>Step</i>
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Setteur du type d'environnement de la <i>Step</i>
     * @param env Le type d'environnement de la <i>Step</i>
     */
    public void setTypeEnv(String env) { this.typeEnv = env; }

    /**
     * Setteur de la liste de <i>Polymons</i> de la <i>Step</i>
     * @param polymons La liste de <i>Polymons</i> de la <i>Step</i>
     */
    public void setPolymons(List<Polymon> polymons) { this.polymons = polymons; }

    /**
     * Setteur de la liste des <i>Steps</i> suivantes
     * @param choix La liste des <i>Steps</i> suivantes
     */
    public void setChoixSuivants(List<String> choix) { this.steps_ids = choix; }
}
