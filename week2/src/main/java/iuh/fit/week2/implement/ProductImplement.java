package iuh.fit.week2.implement;

import iuh.fit.week2.models.Product;
import iuh.fit.week2.repositories.ProductRepository;
import iuh.fit.week2.services.ProductService;
import jakarta.inject.Inject;

import java.util.List;

public class ProductImplement implements ProductService {
    @Inject
    private ProductRepository productRepository;
    private ProductRepository repository=new ProductRepository();
    @Override
    public boolean create(Product product) {
        return repository.create(product);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }
}
