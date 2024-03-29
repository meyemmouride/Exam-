package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

import Model.Employe;

abstract class EmployeDAOImpl implements EmployeDAO {
    private EntityManager entityManager;

    public EmployeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Employe findById(Long id) {
        return entityManager.find(Employe.class, id);
    }


    public List<Employe> findAll() {
        TypedQuery<Employe> query = entityManager.createQuery("SELECT e FROM Employe e", Employe.class);
        return query.getResultList();
    }


    public void save(Employe employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
    }


    public void update(Employe employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(employee);
        transaction.commit();
    }


    public void delete(Employe employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entityManager.contains(employee) ? employee : entityManager.merge(employee));
        transaction.commit();
    }
}

