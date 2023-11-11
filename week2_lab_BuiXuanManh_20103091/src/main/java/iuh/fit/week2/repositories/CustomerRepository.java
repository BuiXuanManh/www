package iuh.fit.week2.repositories;

import iuh.fit.week2.models.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class CustomerRepository {
    private EntityManager em;
    private EntityTransaction tr;

    public CustomerRepository() {
        em= Connection.getInstance().getEmf().createEntityManager();
        tr=em.getTransaction();
    }
    public boolean createCust(Customer e) {
        tr.begin();
        try {
            em.persist(e);
            tr.commit();
            return true;
        }catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
        return false;
    }
    public boolean update(Customer e) {
        tr.begin();
        try {
            em.merge(e);
            tr.commit();
            return true;
        }catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
        return false;
    }

    public List<Customer> findAll() {
        List<Customer> l = em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
        return l;
    }
}
