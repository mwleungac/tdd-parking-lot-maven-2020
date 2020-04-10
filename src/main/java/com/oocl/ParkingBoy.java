package com.oocl;

import java.util.HashMap;

public class ParkingBoy {
    HashMap<Ticket, Car> cars = new HashMap<>();


    public Ticket parkACar(Car car) {
        Ticket ticket = new Ticket();
        cars.put(ticket, car);
        return ticket;

    }

    public Car fetchACar(Ticket ticket) {
        if(cars.containsKey(ticket)){
            Car returnedCar = cars.get(ticket);     //get mapped car value
            return returnedCar;
        }
        return null;
    }
}
