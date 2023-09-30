package vn.edu.iuh.fit.backend.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.backend.enums.ProductStatus;
import vn.edu.iuh.fit.backend.models.Product;

import java.util.List;

public class ProductRepository {
    private EntityManager em;
    private EntityTransaction tr;

    public ProductRepository() {
        em = Connection.getInstance().getEmf().createEntityManager();
        tr = em.getTransaction();
    }

    public List<Product> findTopNewProc(int amount) {
        List<Product> products = em.createNamedQuery("product.findTopProcNew", Product.class).setMaxResults(amount).getResultList();
        return products;
    }

    public boolean create(Product e) {
        tr.begin();
        try {
            em.persist(e);
            tr.commit();
            return true;
        } catch (Exception ex) {
            tr.rollback();
        }
        return false;
    }

    public boolean update(Product e) {
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

    public List<Product> findAll() {
        List<Product> l = em.createNamedQuery("product.findAll", Product.class).getResultList();
        return l;
    }

    public Product findById(Long id) {
        Product p = em.find(Product.class, id);
        return p;
    }

    public boolean delete(Product p) {
        p.setStatus(ProductStatus.TERMINATED);
        if (update(p))
            return true;
        return false;
    }
}
