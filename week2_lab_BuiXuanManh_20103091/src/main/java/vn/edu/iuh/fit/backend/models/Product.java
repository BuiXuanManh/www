package vn.edu.iuh.fit.backend.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.backend.enums.ProductStatus;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@NamedQueries(
        {
                @NamedQuery(name = "product.findAll", query = "select p from Product p where p.status = 1"),
                @NamedQuery(name = "product.findTopProcNew",
                        query = "SELECT p FROM Product p ORDER BY p.productId DESC")
        }
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
