package iuh.fit.week2.repositories;

import iuh.fit.week2.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;

import java.util.List;

public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction tr;

    public EmployeeRepository() {
        em = Connection.getInstance().getEmf().createEntityManager();
        tr = em.getTransaction();
    }

    public boolean create(Employee e) {
        tr.begin();
        try {
            em.persist(e);
            tr.commit();
            return true;
        } catch (Exception ex) {
            tr.rollback();
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(Employee e) {
        tr.begin();
        try {
            em.merge(e);
            tr.commit();
            return true;
        } catch (Exception ex) {
            tr.rollback();

        }
        return false;
    }

    public List<Employee> findAll() {
        List<Employee> l = em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
        return l;
    }
}
