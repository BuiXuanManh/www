package vn.edu.iuh.fit.backend.implement;


import jakarta.inject.Inject;
import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.backend.models.ProductImage;
import vn.edu.iuh.fit.backend.models.ProductPrice;
import vn.edu.iuh.fit.backend.repositories.ProductPriceRepository;
import vn.edu.iuh.fit.backend.service.ProductPriceService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductPriceImplement implements ProductPriceService {
    private ProductPriceRepository productPriceRepository;

    public ProductPriceImplement() {
        productPriceRepository= new ProductPriceRepository();
    }

    @Override
    public Optional<ProductPrice> findById(LocalDateTime id) {
        Optional<ProductPrice> p = productPriceRepository.findById(id);
        return p;
    }

    @Override
    public List<ProductPrice> findAll() {
        List<ProductPrice> l = productPriceRepository.findAll();
        return l;
    }

    @Override
    public boolean create(ProductPrice entity) {
        return productPriceRepository.create(entity);
    }

    @Override
    public boolean update(ProductPrice entity) {
        return productPriceRepository.update(entity);
    }

}

