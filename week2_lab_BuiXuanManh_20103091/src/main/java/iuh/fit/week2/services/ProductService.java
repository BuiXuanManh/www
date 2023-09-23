package iuh.fit.week2.services;

import iuh.fit.week2.models.Product;

import java.util.List;

public interface ProductService {
    boolean create(Product product);
    List<Product> findAll();
}
