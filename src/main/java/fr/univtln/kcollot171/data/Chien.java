package fr.univtln.kcollot171.data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@Entity
@NamedQueries({@NamedQuery(name = "findById", query = "select p from Chien p where p.idC = :id"),
              @NamedQuery(name = "findAll", query = "select p from Chien p")})
public class Chien {
    @XmlElement
    @Id
    @GeneratedValue
    private int idC;
    @XmlElement
    private String nom;
    @XmlElement
    private String race;
    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Pathologie> listePathologie;
    @XmlElement
    @ManyToOne
    private Chenil chenil;

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

    public Chenil getChenil() {
        return chenil;
    }

    public void setChenil(Chenil chenil) {
        this.chenil = chenil;
    }

    public static List<Chien> findAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testpostgresqllocal");
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        List<Chien> chiens = em.createNamedQuery("findAll").getResultList();
        t.commit();
        em.close();
        return chiens;
    }

    public static Chien findById(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testpostgresqllocal");
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        Chien chien = (Chien)em.createNamedQuery("findAll").setParameter("id", id).getSingleResult();
        t.commit();
        em.close();
        return chien;
    }

    @Override
    public String toString() {
        return "Chien{" +
                "idC=" + idC +
                ", nom='" + nom + '\'' +
                ", race='" + race + '\'' +
                ", chenil=" + chenil +
                '}';
    }


}
