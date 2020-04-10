package com.oocl;

public class Ticket {

    private boolean isUsed;
    private boolean isProvided;
    private int code;

    public Ticket() {
    }
    public Ticket(int code) {
        this.code = code;
    }
    public Ticket(boolean isUsed, boolean isProvided) {
        this.isUsed = isUsed;
        this.isProvided = isProvided;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public boolean isProvided() {
        return isProvided;
    }

    public int getCode() {
        return code;
    }
}
