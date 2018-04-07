package fr.univtln.kcollot171.executable;

import fr.univtln.kcollot171.utils.PersonnePK;
import fr.univtln.kcollot171.data.Chenil;
import fr.univtln.kcollot171.data.Chien;
import fr.univtln.kcollot171.data.Pathologie;
import fr.univtln.kcollot171.data.Personne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testpostgresqllocal");
        EntityManager em = emf.createEntityManager();

        Personne p1 = new Personne("Pierre", "Durand");
        Personne p3 = new Personne("Paul", "Durand");
        Personne p2 = new Personne("Test", "Deux");
        Chien chien1 = new Chien("Medor", "Labrador");
        Chien chien2 = new Chien("Rex", "Caniche");
        Chien chien3 = new Chien("Max", "RaceSuspecte");
        Chien chien4 = new Chien("Chien", "Errant");

        Chenil chenil = new Chenil("SPA");

        Pathologie pathologie1 = new Pathologie("Rage", "pas bien vilain");
        Pathologie pathologie2 = new Pathologie("Lèpre", "il manque un morceau");

        List<Pathologie> pathologies = new ArrayList<>();
        pathologies.add(pathologie1);
        pathologies.add(pathologie2);

        Chien chienMalade = new Chien("Malade", "Husky");
        chienMalade.setListePathologie(pathologies);
        p2.setDog(chienMalade);


        chien2.setChenil(chenil);
        chien4.setChenil(chenil);

        System.out.println(p1);
        System.out.println(p2);

        EntityTransaction transac = em.getTransaction();
        transac.begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(chenil);
        em.persist(chien1);
        em.persist(chien2);
        em.persist(chien3);
        em.persist(chien4);
        em.persist(pathologie1);
        em.persist(pathologie2);
        em.persist(chienMalade);
        transac.commit();

        em.refresh(p1);
        em.refresh(p2);

        PersonnePK pk1 = new PersonnePK("Pierre", "Durand");
        p1 = em.find(Personne.class, pk1);
        PersonnePK pk2 = new PersonnePK("Test", "Deux");
        p2 = em.find(Personne.class, pk2);
        PersonnePK pk3 = new PersonnePK("Paul", "Durand");
        p3 = em.find(Personne.class, pk3);

        p1.setAge(25);
        p2.setAge(18);
        p3.setAge(40);


        transac.begin();
        em.merge(p1);
        em.merge(p2);
        em.merge(p3);
        em.remove(chienMalade);
        transac.commit();

        p1.setDog(chien1);
        p3.setDog(chien3);

        transac.begin();
        em.merge(p1);
        em.merge(p3);
        transac.commit();


        em.refresh(chenil);
        List<Chien> chiens = chenil.getListeChien();
        System.out.println(chiens);

        Personne proprio1 = (Personne) em.createNamedQuery("findProprio").setParameter("id", chien1.getId()).getSingleResult();
        System.out.println(proprio1);


    }


}
