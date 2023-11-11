package iuh.fit.week2.model;

import iuh.fit.week2.implement.ProductImplement;
import iuh.fit.week2.models.Product;
import iuh.fit.week2.services.ProductService;

import java.util.List;

public class ProductModel {
    private ProductService service;

    public ProductModel() {
        service= new ProductImplement();
    }
    public List<Product> getAll(){
        return service.findAll();
    }
}
