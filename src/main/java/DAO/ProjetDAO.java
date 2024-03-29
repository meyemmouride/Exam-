package DAO;
import Model.Projet;
import jakarta.persistence.*;
import jakarta.util.List;

public class ProjetDAO {
    private EntityManager entityManager;

    public ProjetDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Projet findById(Long id) {
        return entityManager.find(Projet.class, id);
    }

    // Other methods for CRUD operations
}




