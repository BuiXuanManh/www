package vn.edu.iuh.fit.backend.service;


import vn.edu.iuh.fit.backend.models.ProductImage;

import java.util.List;
import java.util.Optional;

public interface ProductImageService {
    List<ProductImage> findAll();

    Optional<ProductImage> findById(Long id);

    boolean create(ProductImage imageDTO);

    boolean update(ProductImage imageDTO);
}
