package iuh.fit.week2.repositories;

import iuh.fit.week2.models.ProductImage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

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
}
