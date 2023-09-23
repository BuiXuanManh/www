package iuh.fit.week2.repositories;

import iuh.fit.week2.models.Employee;
import iuh.fit.week2.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;

import java.util.List;

public class ProductRepository {
    private EntityManager em;
    private EntityTransaction tr;
    private Logger logger;

    public ProductRepository() {
        em= Connection.getInstance().getEmf().createEntityManager();
        tr=em.getTransaction();
    }

    public boolean create(Product e) {
        tr.begin();
        try {
            em.persist(e);
            tr.commit();
            return true;
        }catch (Exception ex){
            tr.rollback();
            logger.error("error insert product");
        }
        return false;
    }
    public boolean update(Product e) {
        tr.begin();
        try {
            em.merge(e);
            tr.commit();
            return true;
        }catch (Exception ex){
            tr.rollback();
            logger.error("error update product");
        }
        return false;
    }

    public List<Product> findAll() {
        List<Product> l = em.createNamedQuery("Product.findAll", Product.class).getResultList();
        return l;
    }
}
