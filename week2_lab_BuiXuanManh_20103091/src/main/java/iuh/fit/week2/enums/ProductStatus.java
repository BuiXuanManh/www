package iuh.fit.week2.enums;

public enum ProductStatus {
    ACTIVE(1),

    DEACTIVE(0),

    DELETED(-1);

    private int status;

    ProductStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
