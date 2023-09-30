package vn.edu.iuh.fit.backend.implement;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.backend.service.ProductService;

import java.util.List;

public class ProductImplement implements ProductService {
    private ProductRepository repository;

    public ProductImplement() {
        repository= new ProductRepository();
    }

    @Override
    public boolean create(Product product) {
        return repository.create(product);
    }

    @Override
    public boolean update(Product product) {
        return repository.update(product);
    }


    @Override
    public boolean delete(Long id) {
        Product p = repository.findById(id);
        if (p == null)
            return false;
        repository.delete(p);
        return true;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> findTop5ProductNew(int mount) {
        return repository.findTopNewProc(mount);
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
