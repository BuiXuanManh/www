package iuh.fit.week2.repositories;

import iuh.fit.week2.models.Employee;
import iuh.fit.week2.models.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;

import java.util.List;

public class OrderRepository {
    private EntityManager em;
    private EntityTransaction tr;
    private Logger logger;

    public OrderRepository() {
        em= Connection.getInstance().getEmf().createEntityManager();
        tr=em.getTransaction();
    }

    public boolean create(Order e) {
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
    public boolean update(Order e) {
        tr.begin();
        try {
            em.merge(e);
            return true;
        }catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();
        }
        return false;
    }

    public List<Order> findAll() {
        List<Order> l = em.createNamedQuery("Order.findAll", Order.class).getResultList();
        return l;
    }
}
