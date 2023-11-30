package fit.se.week7.backend.services;

import fit.se.week7.backend.dto.ProductDto;
import fit.se.week7.backend.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> getAll();
    Optional<Product> findById(long id);
    Product save(Product product);
    Page<ProductDto> findPage(int pageNo, int pageSize, String sortBy, String sortDerection);
    List<ProductDto> getProduct(String userName);
    List<ProductDto> getProduct();
    Optional<ProductDto> findByProdId(Long id);
}
