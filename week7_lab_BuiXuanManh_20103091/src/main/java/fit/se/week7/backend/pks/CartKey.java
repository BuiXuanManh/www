package fit.se.week7.backend.pks;

import fit.se.week7.backend.models.Product;
import fit.se.week7.backend.models.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class CartKey implements Serializable {
    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;
}
