package fr.univtln.kcollot171.data;

import fr.univtln.kcollot171.data.Chien;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pathologie {
    @Id
    @GeneratedValue
    private int idPathologie;
    private String nomPath;
    private String description;

    @ManyToMany(mappedBy = "listePathologie")
    private List<Chien> listeChiens;

    public Pathologie(String nom, String desc) {
        this.nomPath = nom;
        this.description = desc;
    }

    public Pathologie() {
    }

    public int getIdPathologie() {
        return idPathologie;
    }

    public void setIdPathologie(int idPathologie) {
        this.idPathologie = idPathologie;
    }

    public String getNom() {
        return nomPath;
    }

    public void setNom(String nom) {
        this.nomPath = nom;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public List<Chien> getListeChiens() {
        return listeChiens;
    }

    public void setListeChiens(List<Chien> listeChiens) {
        this.listeChiens = listeChiens;
    }

}
