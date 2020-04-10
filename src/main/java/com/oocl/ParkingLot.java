package com.oocl;

import java.util.ArrayList;

public class ParkingLot {

    int capacity;
    int parkedCount;
    ArrayList<Car> carList;

    public ParkingLot(int capacity, int parkedCount) {
        this.capacity = capacity;
        this.parkedCount = parkedCount;
        this.carList = new ArrayList<>();
    }

    public boolean isFull() {
        if(capacity == parkedCount){
            return true;
        }
        return false;
    }
}
