package iuh.fit.week2.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "order")
public class Order {
    @Id
    private String orderId;
    private LocalDateTime order_date;
    @ManyToOne
    @Column(name = "emp_id")
    private Employee employee;
    @ManyToOne
    @Column(name = "cust_id")
    private Customer customer;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order() {
    }

    public Order(String orderId, LocalDateTime order_date, Employee employee, Customer customer) {
        this.orderId = orderId;
        this.order_date = order_date;
        this.employee = employee;
        this.customer = customer;
    }
}
