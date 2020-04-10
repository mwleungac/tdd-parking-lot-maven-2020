package com.oocl;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    int capacity;
    int parkedCarCount;
    boolean isFulled = false;
    private ArrayList<Car> carList;

    public ParkingLot() {
        this(10);
    }
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.carList = new ArrayList<>();
        this.capacity = capacity;
    }
    public ParkingLot(int capacity, int parkedCarCount) {
        this.capacity = capacity;
        this.parkedCarCount = parkedCarCount;
        this.carList = new ArrayList<>();
    }

    public int getRemainingCount() {
        return capacity -  parkedCarCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getParkedCarCount() {
        return parkedCarCount;
    }

    public void setParkedCarCount() {
        if(this.parkedCarCount == this.capacity){
            this.isFulled = true;
        }else{
            this.parkedCarCount ++;
        }
    }


    public static Ticket getATicket() {
        return new Ticket(false,true);
    }

    public static ArrayList<Ticket> getTickets(ArrayList<Car> carList) {
        return new ArrayList<Ticket>();
    }

    public boolean isCapacityFulled() {
        if(this.parkedCarCount < this.capacity){
            return false;
        }else{
            this.isFulled = true;
            return true;
        }
    }

    public List<Car> getCars() {
        return carList;
    }
    public void removeCar(Car car) {
        carList.remove(car);
    }
    public void park(Car car) {
        this.carList.add(car);
    }
    public boolean isFull() {
        return carList.size() >= capacity;
    }
}
