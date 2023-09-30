package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.backend.models.Customer;

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
    public Customer findById(Long id){
        Customer c = em.find(Customer.class, id);
        return c;
    }
}
