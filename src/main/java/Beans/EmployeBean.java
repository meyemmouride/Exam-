import DAO.EmployeDAOImpl;
import DAO.EmployeeDAOImpl;
import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Employe;
import DAO.EmployeeDAOImpl;

import java.util.List;

@ManagedBean
@RequestScoped
public class EmployeBean {
    private List<Employe> listeEmployes;

    @PostConstruct
    public void init() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // Initialisation de la liste des employés depuis la base de données
            EmployeDAO employeeDAO = new EmployeDAOImpl(entityManager);
            listeEmployes = employeeDAO.findAll();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public List<Employe> getListeEmployes() {
        return listeEmployes;
    }

    public void setListeEmployes(List<Employe> listeEmployes) {
        this.listeEmployes = listeEmployes;
    }
}
