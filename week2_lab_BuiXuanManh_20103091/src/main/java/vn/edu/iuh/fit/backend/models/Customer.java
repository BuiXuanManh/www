package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@NamedQueries(
        @NamedQuery(name = "Customer.findAll",query = "SELECT e FROM Customer e")
)
public class Customer {
    @Id
    @Column(name = "cust_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;
    @Column(name = "cust_name")
    private String custName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    public Customer(String custName, String email, String phone, String address) {
        this.custName = custName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
