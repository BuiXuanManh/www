package iuh.fit.week5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private Long id;
    @Column(name = "to_date")
    private LocalDate toDate;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(columnDefinition = "varchar(120)")
    private String company;
    @Column(columnDefinition = "varchar(100)")
    private String role;
    @Column(name = "work_desc",columnDefinition = "varchar(400)")
    private String workDescription;
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

}
