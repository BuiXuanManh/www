package iuh.fit.week2.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_image")
@Data
@NoArgsConstructor
@NamedQueries(
        @NamedQuery(name = "ProductImage.findAll",query = "SELECT e FROM ProductImage e")
)
public class ProductImage {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String path;
    private String alternative;

    public ProductImage(Product product,  String path, String alternative) {
        this.product = product;
        this.path = path;
        this.alternative = alternative;
    }

}
