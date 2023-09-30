package vn.edu.iuh.fit.backend.service;


import vn.edu.iuh.fit.backend.models.Product;

import java.util.List;

public interface ProductService {
    boolean create(Product product);
    boolean update(Product product);
    boolean delete(Long id);
    List<Product> findAll();
    List<Product> findTop5ProductNew(int mount);
    Product findById(Long id);
}
