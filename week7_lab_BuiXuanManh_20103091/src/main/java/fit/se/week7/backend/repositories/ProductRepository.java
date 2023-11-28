package fit.se.week7.backend.repositories;

import fit.se.week7.backend.dto.ProductDto;
import fit.se.week7.backend.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select new fit.se.week7.backend.dto.ProductDto(p.name,pp.price,pi.path) from Product p join ProductPrice pp on p.id=pp.product.id join ProductImage pi on pi.product.id=p.id where p.status=0")
    List<ProductDto> getProduct();
    @Query("select new fit.se.week7.backend.dto.ProductDto(p.name,pp.price,pi.path) from Product p join ProductPrice pp on p.id=pp.product.id join ProductImage pi on pi.product.id=p.id where p.status=0")
    Page<ProductDto> getProduct(Pageable pageable);
}
