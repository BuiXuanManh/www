package fit.se.week7.backend.repositories;

import fit.se.week7.backend.models.ProductPrice;
import fit.se.week7.backend.pks.ProductPricePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPricePK> {
}
