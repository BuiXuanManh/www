package iuh.fit.week2.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.repositories.Connection;

import java.time.LocalDate;
import java.util.List;

public class OrderRepository {
    private EntityManager em;
    private EntityTransaction tr;

    public OrderRepository() {
        em = Connection.getInstance().getEmf().createEntityManager();
        tr = em.getTransaction();
    }

    public boolean create(Order e) {
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

    public boolean update(Order e) {
        tr.begin();
        try {
            em.merge(e);
            tr.commit();
            return true;
        } catch (Exception ex) {
            tr.rollback();
            ex.printStackTrace();
        }
        return false;
    }

    public List<Order> findAll() {
        List<Order> l = em.createNamedQuery("Order.findAll", Order.class).getResultList();
        return l;
    }
    public List<Order> findOrdersByDate(LocalDate date) {
        List<Order> l = em.createQuery("SELECT o FROM Order o WHERE o.order_date = :date")
                .setParameter("date", date)
                .getResultList();

        return l;
    }
    public List<Order> findOrdersByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Order> l = em.createQuery("SELECT o FROM Order o WHERE o.order_date BETWEEN :startDate AND :endDate")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
        return l;
    }

    public List<Order> findOrdersByEmployeeDateAndRange(LocalDate startDate, LocalDate endDate, String employee) {
        List<Order> l = em.createQuery("SELECT o FROM Order o WHERE o.order_date BETWEEN :startDate AND :endDate and :id=o.employee.id")
                .setParameter("id",employee)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
        return l;
    }
    public Order find(Long id){
        Order o = em.find(Order.class, id);
        return o;
    }
}
