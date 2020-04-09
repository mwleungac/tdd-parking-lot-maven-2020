package com.oocl;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Ticket, Car> cars = new HashMap<Ticket, Car>();
    int ParkingLotCapacity = 0;

    public Ticket park(Car car) {
        int maxParkingCapacity = 2;

        if(ParkingLotCapacity < maxParkingCapacity) {
            Ticket ticket = new Ticket();       //return ticket for parked car
            cars.put(ticket, car);              //map car and corresponding ticket
            ParkingLotCapacity = ParkingLotCapacity + 1;
            System.out.println(ParkingLotCapacity);
            return ticket;

        }
        return null;

    }

    public Car fetch(Ticket ticket, boolean ticketIsUsed) {
        if(ticketIsUsed == true){
            return cars.remove(ticket.toString());
        }
        else if (ticketIsUsed == false) {
            //  Car car = cars.remove(ticket.toString());     // remove used ticket inside the map
            // return car;
            return cars.get(ticket);        //get corresponding car by ticket
        }

        return null;
    }
}
