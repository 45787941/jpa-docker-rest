package fr.univtln.kcollot171.executable;

import fr.univtln.kcollot171.utils.PersonnePK;
import fr.univtln.kcollot171.data.Personne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test1 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testpostgresqllocal");
        EntityManager em = emf.createEntityManager();

        PersonnePK pk1 = new PersonnePK("Pierre", "Durand");
        PersonnePK pk2 = new PersonnePK("Test", "Deux");

        Personne p1 = new Personne();
        Personne p2 = new Personne();
        System.out.println(p1);
        System.out.println(p2);

        EntityTransaction transac = em.getTransaction();
        transac.begin();
        em.persist(p1);
        em.persist(p2);
        transac.commit();

        em.refresh(p1);
        em.refresh(p2);

        System.out.println(p1);
        System.out.println(p2);

    }


}
