package fit.se.week7.backend.pks;

import fit.se.week7.backend.models.Order;
import fit.se.week7.backend.models.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;
}
