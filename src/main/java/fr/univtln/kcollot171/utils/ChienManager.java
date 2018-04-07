package fr.univtln.kcollot171.utils;

import fr.univtln.kcollot171.data.Chien;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ChienManager extends Observable {
    final List<Chien> chiens = new ArrayList<>();

    public ChienManager(){

    }

    public List<Chien> getChiens(){
        return Chien.findAll();
    }

    public Chien getChien(int id){
        return Chien.findById(id);
    }

    public void deleteChien(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testpostgresqllocal");
        EntityManager em = emf.createEntityManager();
        Chien chien = chiens.get(id);
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.remove(chien);
        t.commit();
        em.close();
    }

    public void majChien(Chien chien){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testpostgresqllocal");
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(chien);
        t.commit();
        em.close();
    }

    public void addChien(String nom, String race){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testpostgresqllocal");
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(new Chien(nom, race));
        t.commit();
        em.close();
    }

    public void addChien(Chien chien){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testpostgresqllocal");
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(chien);
        t.commit();
        em.close();
    }
}
