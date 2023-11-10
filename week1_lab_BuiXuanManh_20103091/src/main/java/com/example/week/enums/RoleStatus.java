package com.example.week.enums;

public enum RoleStatus {
    DEACTIVE(0),
    ACTIVE(1),

    DELETED(-1);
    private int s;

    RoleStatus(int status) {
        this.s = status;
    }

    public int getS() {
        return s;
    }
}
