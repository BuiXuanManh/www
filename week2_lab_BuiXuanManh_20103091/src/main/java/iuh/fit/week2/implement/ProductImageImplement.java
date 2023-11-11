package iuh.fit.week2.implement;

import iuh.fit.week2.models.ProductImage;
import iuh.fit.week2.repositories.ProductImageRepository;
import iuh.fit.week2.services.ProductImageService;

import java.util.List;

public class ProductImageImplement implements ProductImageService {
    private ProductImageRepository repository;

    public ProductImageImplement() {
        repository= new ProductImageRepository();
    }

    @Override
    public List<ProductImage> findAll() {
        return repository.findAll();
    }
}
