package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order_detail")
@NamedQueries({
        @NamedQuery(name = "orderDetail.findAll", query = "select od  from OrderDetail od"),
        @NamedQuery(name = "orderDetail.findById",
                query = "select od  from OrderDetail od where od.order.id=:orderId and od.product.id= :procId"),
})
public class OrderDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "price_id")
    private ProductPrice price;
    @Column(name = "note")
    private String note;

    public OrderDetail(Order order, Product product, int quantity, ProductPrice price, String note) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }
}
