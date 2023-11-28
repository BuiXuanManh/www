package fit.se.week7.backend.services;

import fit.se.week7.backend.models.ProductImage;
import fit.se.week7.backend.models.ProductPrice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductImageService {
    List<ProductImage> getAll();
    ProductImage save(ProductImage productImage);
}
