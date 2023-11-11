package iuh.fit.week2.models;

import iuh.fit.week2.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@NamedQueries(
        @NamedQuery(name = "Product.findAll",query = "SELECT e FROM Product e WHERE e.status = 1")
)
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "unit")
    private String unit;
    @Column(name = "manufacturer_name")
    private String manufacturerName;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status",columnDefinition = "int")
    private ProductStatus status;

    public Product( String name, String description, String unit, String manufacturerName, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.status = status;
    }

}
