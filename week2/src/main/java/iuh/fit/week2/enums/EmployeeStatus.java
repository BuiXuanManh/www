package iuh.fit.week2.enums;

public enum EmployeeStatus {
    ACTIVE(1),

    DEACTIVE(0),

    DELETED(-1);

    private int status;

    EmployeeStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
