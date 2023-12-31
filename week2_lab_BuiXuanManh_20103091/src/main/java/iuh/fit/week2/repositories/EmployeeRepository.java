package iuh.fit.week2.repositories;

import iuh.fit.week2.enums.EmployeeStatus;
import iuh.fit.week2.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

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

    public Optional<Employee> findById(Long id) {
        Optional<Employee> l = Optional.ofNullable(em.find(Employee.class, id));
        return l;
    }

    public boolean delete(Employee e) {
        e.setStatus(EmployeeStatus.DELETED);
        if (update(e))
            return true;
        return false;
    }

}
