package iuh.fit.week5.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CandidateStatus {
    ACTIVE(0),
    TERMINAL(1),
    DELETED(2);
    private int status;
}
