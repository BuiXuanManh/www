package iuh.fit.week2.enums;

public enum ProductStatus {
    DEACTIVE(0),
    ACTIVE(1),
    DELETED(-1);

    private int status;

    ProductStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
