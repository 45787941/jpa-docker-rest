package fr.univtln.kcollot171.utils;

import java.io.Serializable;

public class PersonnePK implements Serializable{
    private String nom;
    private String prenom;

    public PersonnePK(String prenom, String nom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public PersonnePK() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonnePK that = (PersonnePK) o;

        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        return prenom != null ? prenom.equals(that.prenom) : that.prenom == null;
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        return result;
    }
}
