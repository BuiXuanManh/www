package iuh.fit.week5.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SkillLevel {
    MASTER(0),
    BEGINER(1),
    ADVANCED(2),
    PROFESSIONAL(3),
    IMTERMEDIATE(4);
    private int skill;
}
