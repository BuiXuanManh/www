package iuh.fit.week5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "candidate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private Long id;
    @Column(columnDefinition = "varchar(15)")
    private String phone;
    private LocalDate dob;
    private String email;
    private String fullName;
    @OneToOne
    @JoinColumn(name = "address")
    private Address address;

}
