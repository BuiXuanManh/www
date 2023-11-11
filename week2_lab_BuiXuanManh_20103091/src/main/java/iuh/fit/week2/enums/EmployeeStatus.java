package iuh.fit.week2.enums;

public enum EmployeeStatus {
    DEACTIVE(0),
    ACTIVE(1),
    DELETED(-1);

    private int status;

    EmployeeStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
