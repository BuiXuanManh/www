package fit.se.week7.backend.models;

import fit.se.week7.backend.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "name", length = 150, nullable = false)
    private String name;
    @Lob
    @Column(name = "description",  columnDefinition = "text", nullable = false)
    private String description;
    @Column(name = "unit", length = 25, nullable = false)
    private String unit;
    @Column(name = "manufacturer_name", length = 100, nullable = false)
    private String manufacturer;

    @Column(name = "status")
    private ProductStatus status;

//    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
//    private List<ProductImage> productImageList = new ArrayList<>();
//
//    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
//    private List<OrderDetail> orderDetails = new ArrayList<>();
//    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
//    private List<ProductPrice> productPrices = new ArrayList<>();

    public Product(String name, String description, String unit, String manufacturer, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.status = status;
    }

}
