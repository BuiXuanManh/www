package iuh.fit.week2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
@NamedQueries(
        @NamedQuery(name = "Customer.findAll",query = "SELECT e FROM Customer e")
)
public class Customer {
    @Id
    @Column(name = "cust_id")
    private String custId;
    @Column(name = "cust_name")
    private String custName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer() {
    }

    public Customer(String custId, String custName, String email, String phone, String address) {
        this.custId = custId;
        this.custName = custName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
