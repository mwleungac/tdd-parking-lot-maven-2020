package com.oocl;

public class ParkingTicket {
    private Car car;
    private Boolean availability = true;

    public ParkingTicket (Car car){
        this.car = car;
    }

    public ParkingTicket (){

    }

    public Car getCar() {
        availability = false;
        return this.car;
    }

    public Boolean getAvailability() {
        return this.availability;
    }
}
