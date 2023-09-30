package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.backend.models.ProductImage;
import vn.edu.iuh.fit.backend.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductImageRepository {
    private EntityManager em;
    private EntityTransaction tr;
    public ProductImageRepository() {
        em= Connection.getInstance().getEmf().createEntityManager();
        tr= em.getTransaction();
    }
    public List<ProductImage> findAll(){
        List<ProductImage> l = em.createNamedQuery("ProductImage.findAll", ProductImage.class).getResultList();
        return l;
    }
    public Optional<ProductImage> findById(Long Id) {
        ProductImage i = em.find(ProductImage.class, Id);
        return i == null ? Optional.empty() : Optional.of(i);
    }


    public boolean create(ProductImage entity) {
        try {
            tr.begin();
            em.persist(entity);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

    public boolean update(ProductImage entity) {
        try {
            tr.begin();
            em.merge(entity);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
        }
        return false;
    }

}
