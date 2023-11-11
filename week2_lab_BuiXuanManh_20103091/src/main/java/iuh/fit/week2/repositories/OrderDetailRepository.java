package iuh.fit.week2.repositories;

import iuh.fit.week2.models.OrderDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OrderDetailRepository {
    private EntityManager em;
    private EntityTransaction tr;
    public OrderDetailRepository() {
        em= Connection.getInstance().getEmf().createEntityManager();
        tr=em.getTransaction();
    }
    public boolean create(OrderDetail e) {
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
}
