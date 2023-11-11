package iuh.fit.week2.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product_price")
public class ProductPrice {
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Id
    @Column(name = "price_date_time")
    private LocalDateTime priceDatetime;

    @Column(name = "price")
    private double price;
    @Column(name = "note")
    private String note;

    public ProductPrice(Product product, LocalDateTime priceDatetime, double price, String note) {
        this.product = product;
        this.priceDatetime = priceDatetime;
        this.price = price;
        this.note = note;
    }
}
