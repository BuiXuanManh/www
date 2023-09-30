package vn.edu.iuh.fit.backend.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@NamedQueries(
        @NamedQuery(name = "Employee.findAll",query = "SELECT e FROM Employee e WHERE e.status = 1")
)
public class Employee {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(columnDefinition = "int")
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatus status;

    public Employee( String fullName, LocalDate dob, String email, String phone, String address, EmployeeStatus status) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }
}
