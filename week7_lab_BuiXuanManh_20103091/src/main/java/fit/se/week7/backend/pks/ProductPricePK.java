package fit.se.week7.backend.pks;

import fit.se.week7.backend.models.Product;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPricePK implements Serializable {
    private Product product;
    private LocalDateTime priceDatetime;
}
