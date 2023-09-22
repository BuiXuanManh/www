package iuh.fit.week2.repositories;

import iuh.fit.week2.models.Customer;
import iuh.fit.week2.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;

import java.util.List;

public class CustomerRepository {
    private EntityManager em;
    private EntityTransaction tr;
    private Logger logger;

    public CustomerRepository() {
        em= Connection.getInstance().getEmf().createEntityManager();

    }

    public boolean createCust(Customer e) {
        tr=em.getTransaction();
        try {

            tr.begin();
            em.persist(e);
            return true;
        }catch (Exception ex){
            tr.rollback();
            logger.error("error insert cust");
        }
        return false;
    }
    public boolean update(Customer e) {
        tr=em.getTransaction();
        try {
            tr.begin();
            em.merge(e);
            return true;
        }catch (Exception ex){
            tr.rollback();
            logger.error("error update cust");
        }
        return false;
    }

    public List<Customer> findAll() {
        List<Customer> l = em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
        return l;
    }
}
