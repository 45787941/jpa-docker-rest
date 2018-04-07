package fr.univtln.kcollot171.data;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chenil {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idChenil;
    private String nomChenil;
    
    @OneToMany(mappedBy = "chenil")
    private List<Chien> listeChien;

    public Chenil(String nomChenil) {
        this.nomChenil = nomChenil;
    }

    public Chenil(){}

    public List<Chien> getListeChien() {
        return listeChien;
    }

    public int getIdChenil() {

        return idChenil;
    }

    public void setIdChenil(int idChenil) {
        this.idChenil = idChenil;
    }

    public String getNomChenil() {
        return nomChenil;
    }

    public void setNomChenil(String nomChenil) {
        this.nomChenil = nomChenil;
    }

    @Override
    public String toString() {
        return "Chenil{" +
                "idChenil=" + idChenil +
                ", nomChenil='" + nomChenil + '\'' +
                '}';
    }
}
