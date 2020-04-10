package com.oocl;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingBoy {
    HashMap<Ticket, Car> cars = new HashMap<>();
    private int parkingCapacity;
    private ArrayList<ParkingLot> parkingLotList;



    public Ticket parkACar(Car car) {
        ParkingLot parkingLot = new ParkingLot(10,10);

        if(parkingLot.isFull() == false) {

            Ticket ticket = new Ticket();
            cars.put(ticket, car);
            return ticket;
        }
        return null;
    }


    public Car fetchACar(Ticket ticket) {
        if(cars.containsKey(ticket)){
            Car returnedCar = cars.get(ticket);     //get mapped car value
            return returnedCar;
        }
        return null;
    }
}
