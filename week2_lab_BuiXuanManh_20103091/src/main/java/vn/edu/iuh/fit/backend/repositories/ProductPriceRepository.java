package vn.edu.iuh.fit.backend.repositories;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductPriceRepository {
    private EntityManager em;
    private EntityTransaction tr;
    private final Logger logger;

    public ProductPriceRepository() {
        em = Connection.getInstance().getEmf().createEntityManager();
        tr = em.getTransaction();
        logger = LoggerFactory.getLogger(this.getClass());
    }

    public Optional<ProductPrice> findById(LocalDateTime localDateTime) {
        ProductPrice productPrice = (ProductPrice) em.createNamedQuery("ProductPrice.finById", ProductPrice.class).setParameter("id", localDateTime).getSingleResult();

        return productPrice == null ? Optional.empty() : Optional.of(productPrice);
    }

    public List<ProductPrice> findAll() {
        List<ProductPrice> productPrices = em.createNamedQuery("ProductPrice.findAll", ProductPrice.class).getResultList();
        return productPrices;
    }

    public boolean create(ProductPrice entity) {
        try {
            tr.begin();
            em.persist(entity);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

    public boolean update(ProductPrice entity) {
        try {
            tr.begin();
            em.merge(entity);
            tr.commit();
            return true;
        } catch (Exception e) {
            tr.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }

}
