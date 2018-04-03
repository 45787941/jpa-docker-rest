package fr.univtln.kcollot171.data;

import fr.univtln.kcollot171.utils.PersonnePK;

import javax.persistence.*;

@Entity
@NamedQuery(name = "findProprio", query = "select p from Personne p where p.dog.idC = :id")
@IdClass(PersonnePK.class)
public class Personne {
    /*@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;*/
    @Id
    private String prenom;
    @Id
    private String nom;
    private int age;
    @JoinColumn
    @OneToOne(cascade = CascadeType.PERSIST)
    private Chien dog;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public Personne(String prenom, String nom, int age, Chien dog) {

        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.dog = dog;
    }

    public void setDog(Chien dog) {

        this.dog = dog;
    }

    public Personne(String prenom, String nom, int age) {
        /*this.prenom = prenom;
        this.nom = nom;*/
        this.age = age;
    }

    public Personne(){}


    public Personne(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                '}';
    }
}
