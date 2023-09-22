package iuh.fit.week2.repositories;

import iuh.fit.week2.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;

import java.util.List;

public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction tr;
    private Logger logger;

    public EmployeeRepository() {
        em= Connection.getInstance().getEmf().createEntityManager();

    }

    public boolean create(Employee e) {
        tr=em.getTransaction();
        try {

            tr.begin();
            em.persist(e);
            return true;
        }catch (Exception ex){
            tr.rollback();
            logger.error("error insert emp");
        }
        return false;
    }
    public boolean update(Employee e) {
        tr=em.getTransaction();
        try {

            tr.begin();
            em.merge(e);
            return true;
        }catch (Exception ex){
            tr.rollback();
            logger.error("error update emp");
        }
        return false;
    }

    public List<Employee> findAll() {
        List<Employee> l = em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
        return l;
    }
}
