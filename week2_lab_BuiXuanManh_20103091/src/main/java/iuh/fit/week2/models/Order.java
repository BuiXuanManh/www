package iuh.fit.week2.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@NamedQueries(
        @NamedQuery(name = "Order.findAll",query = "SELECT e FROM Order e")
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private LocalDateTime order_date;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;
    public Order( LocalDateTime order_date, Employee employee, Customer customer) {
        this.order_date = order_date;
        this.employee = employee;
        this.customer = customer;
    }
}
