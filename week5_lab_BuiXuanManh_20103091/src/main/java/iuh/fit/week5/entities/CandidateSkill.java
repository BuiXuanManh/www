package iuh.fit.week5.entities;

import iuh.fit.week5.enums.SkillLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "candidateSkill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Column(name = "skill_level",columnDefinition = "tinyint(4)")
    @Enumerated(EnumType.ORDINAL)
    private SkillLevel skillLevel;
    @Column(name = "more_infos",columnDefinition = "varchar(1000)")
    private String moreInfo;


}
