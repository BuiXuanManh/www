package vn.edu.iuh.fit.backend.implement;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.backend.models.ProductImage;
import vn.edu.iuh.fit.backend.repositories.ProductImageRepository;
import vn.edu.iuh.fit.backend.service.ProductImageService;

import java.util.List;
import java.util.Optional;

public class ProductImageImplement implements ProductImageService {
    private ProductImageRepository repository;

    public ProductImageImplement() {
        repository= new ProductImageRepository();
    }

    @Override
    public List<ProductImage> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductImage> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean create(ProductImage imageDTO) {
        return repository.create(imageDTO);
    }

    @Override
    public boolean update(ProductImage imageDTO) {
        return repository.update(imageDTO);
    }
}
