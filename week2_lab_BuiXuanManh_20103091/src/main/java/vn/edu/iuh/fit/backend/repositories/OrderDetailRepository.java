package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.models.OrderDetail;

import java.util.List;
import java.util.Optional;

public class OrderDetailRepository {
    private EntityManager em;
    private EntityTransaction tr;

    public OrderDetailRepository() {
        em = Connection.getInstance().getEmf().createEntityManager();
        tr = em.getTransaction();
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

    public boolean update(OrderDetail e) {
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

    public List<OrderDetail> findAll() {
        List<OrderDetail> l = em.createNamedQuery("orderDetail.findAll", OrderDetail.class).getResultList();
        return l;
    }

    public OrderDetail findById(Long pid, Long orderId) {
        OrderDetail l = em.createNamedQuery("orderDetail.findById",OrderDetail.class).setParameter(":orderId",orderId).setParameter("procId",pid).getSingleResult();
        return l;
    }

}
