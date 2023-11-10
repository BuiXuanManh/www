package com.example.week.enums;

public enum AccountStatus {
    DEACTIVE(0),
    ACTIVE(1),

    DELETED(-1);

    private int s;

    AccountStatus(int status) {
        this.s = status;
    }

    public int getS() {
        return s;
    }
}
