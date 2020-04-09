package com.oocl;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Ticket, Car> cars = new HashMap<Ticket, Car>();

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();       //return ticket for parked car
        cars.put(ticket, car);              //map car and corresponding ticket
        return ticket;
    }

    public Car fetch(Ticket ticket) {
       Car car = cars.remove(ticket.toString());     // remove used ticket inside the map
        return car;
       // return cars.get(ticket);        //get corresponding car by ticket
    }
}
