package com.oocl;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingBoy {
    HashMap<Ticket, Car> cars = new HashMap<>();
    private int parkingCapacity;
    private ArrayList<ParkingLot> parkingLotList;
    private String ErrorMsg;


    public Ticket parkACar(Car car) {
        ParkingLot parkingLot = new ParkingLot(10,10);

        if(parkingLot.isFull() == false) {

            Ticket ticket = new Ticket();
            cars.put(ticket, car);
            return ticket;
        }
        this.setErrorMsg("Not enough position.");
        return null;
    }


    public Car fetchACar(Ticket ticket) {
        if(cars.containsKey(ticket)){
            Car returnedCar = cars.get(ticket);     //get mapped car value
            return returnedCar;
        }
        if(ticket == null) {
            this.setErrorMsg("Please provide your parking ticket.");
            return null;
        }
        this.setErrorMsg("Unrecognized parking ticket.");
        return null;

    }

    private void setErrorMsg(String errorMsg) {
        ErrorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return ErrorMsg;
    }
}
