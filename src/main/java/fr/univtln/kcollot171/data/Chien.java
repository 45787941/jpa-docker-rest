package fr.univtln.kcollot171.data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chien {
    @Id
    @GeneratedValue
    private int idC;
    private String nom;
    private String race;
    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Pathologie> listePathologie;
    @ManyToOne
    private Chenil idChenil;

    public Chien(String nom, String race, List<Pathologie> listePathologie) {
        this.nom = nom;
        this.race = race;
        this.listePathologie = listePathologie;
    }

    public List<Pathologie> getListePathologie() {
        return listePathologie;
    }

    public void setListePathologie(List<Pathologie> listePathologie) {
        this.listePathologie = listePathologie;
    }

    public Chien() {
    }

    public Chien(String nom, String race) {
        this.nom = nom;
        this.race = race;
    }

    public int getId() {
        return idC;
    }

    public void setId(int id) {
        this.idC= id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Chenil getIdChenil() {
        return idChenil;
    }

    public void setIdChenil(Chenil idChenil) {
        this.idChenil = idChenil;
    }

    @Override
    public String toString() {
        return "Chien{" +
                "idC=" + idC +
                ", nom='" + nom + '\'' +
                ", race='" + race + '\'' +
                ", idChenil=" + idChenil +
                '}';
    }
}
