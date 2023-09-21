package iuh.fit.week2.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @ManyToOne
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

    public ProductPrice() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getPriceDatetime() {
        return priceDatetime;
    }

    public void setPriceDatetime(LocalDateTime priceDatetime) {
        this.priceDatetime = priceDatetime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
