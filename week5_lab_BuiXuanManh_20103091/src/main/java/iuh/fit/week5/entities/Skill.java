package iuh.fit.week5.entities;

import iuh.fit.week5.enums.SkillType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skill")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long id;
    @Column(name = "skil_name",columnDefinition = "varchar(150)")
    private String skillName;
    @Column(name = "skill_desc")
    private String skillDescription;
    @Column(columnDefinition = "tinyint(4)")
    @Enumerated(EnumType.ORDINAL)
    private SkillType skillType;
}
