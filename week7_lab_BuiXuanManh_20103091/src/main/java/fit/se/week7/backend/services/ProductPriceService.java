package fit.se.week7.backend.services;

import fit.se.week7.backend.models.Product;
import fit.se.week7.backend.models.ProductPrice;
import fit.se.week7.backend.pks.ProductPricePK;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductPriceService {
    List<ProductPrice> getAll();
    Optional<ProductPrice> findById(ProductPricePK productPricePK);
    ProductPrice save(ProductPrice productPrice);
}
