package vn.edu.iuh.fit.backend.service;

import org.modelmapper.ModelMapper;
import vn.edu.iuh.fit.backend.models.ProductImage;
import vn.edu.iuh.fit.backend.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProductPriceService {


    Optional<ProductPrice> findById(LocalDateTime id);
    List<ProductPrice> findAll();
    boolean create(ProductPrice entity);

    boolean update(ProductPrice entity);

}
