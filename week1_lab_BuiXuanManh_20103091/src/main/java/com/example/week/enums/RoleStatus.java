package com.example.week.enums;

public enum RoleStatus {
    ACTIVE(1),
    DEACTIVE(0),
    DELETED(-1);
    private int status;

    RoleStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
