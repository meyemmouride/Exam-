package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;
import Model.Projet;


public class ProjetDAOImpl implements ProjetDAO {
    private EntityManager entityManager;

    public ProjetDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Projet findById(Long id) {
        return entityManager.find(Projet.class, id);
    }


    public List<Projet> findAll() {
        TypedQuery<Projet> query = entityManager.createQuery("SELECT p FROM Projet p", Projet.class);
        return query.getResultList();
    }


    public void save(Projet projet) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(projet);
        transaction.commit();
    }


    public void update(Projet projet) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(projet);
        transaction.commit();
    }


    public void delete(Projet projet) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entityManager.contains(projet) ? projet : entityManager.merge(projet));
        transaction.commit();
    }
}

