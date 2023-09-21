package iuh.fit.week2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @ManyToOne
    @Column(name = "order_id")
    private Order order;
    @Id
    @ManyToOne
    @Column(name = "product_id")
    private Product product;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private double price;
    @Column(name = "note")
    private String note;

    public OrderDetail(Order order, Product product, int quantity, double price, String note) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public OrderDetail() {
    }
}
