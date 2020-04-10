package com.oocl;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ParkingBoyTest {

    @Test
    public void return_ticket_when_car_parked() {

        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        Assert.assertNotNull(parkingBoy.parkACar(car));
    }

    @Test
    public void return_car_when_ticket_fetched() {

        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();                            //Car@a294a6
        Ticket ticket = parkingBoy.parkACar(car);       //Ticket@533e64

        Car returnedCar = parkingBoy.fetchACar(ticket);     //Car@a294a6
        Assert.assertEquals(car, returnedCar);
    }

    @Test
    public void no_car_fetched_when_no_ticket() {

        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();                            //Car@a294a6
        Ticket ticket = parkingBoy.parkACar(car);       //Ticket@533e64

        Car returnedCar = parkingBoy.fetchACar(null);     //null
        Assert.assertNull(returnedCar);
    }

    @Test
    public void no_car_fetched_when_wrong_ticket() {

        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();                            //Car@a294a6
        Ticket ticket = parkingBoy.parkACar(car);       //Ticket@533e64

        Car returnedCar = parkingBoy.fetchACar(new Ticket());     //wrong ticket
        Assert.assertNull(returnedCar);
    }

    @Test
    public void cannot_park_car_if_no_position() {
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkinglot = new ParkingLot(10,10);

        boolean checkIsFull = parkinglot.isFull();
        System.out.println(checkIsFull);

        Car car = new Car();
        Ticket ticket = parkingBoy.parkACar(car);
        System.out.println(ticket);

    }

    @Test
    public void error_if_wrong_ticket_fetched() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket();

        Car returnedCar = parkingBoy.fetchACar(new Ticket());
        Assert.assertEquals("Unrecognized parking ticket.",parkingBoy.getErrorMsg());

    }

    @Test
    public void error_if_no_ticket_fetched() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket();

        Car returnedCar = parkingBoy.fetchACar(null);
        Assert.assertEquals("Please provide your parking ticket.",parkingBoy.getErrorMsg());

    }

    @Test
    public void error_if_not_enough_position() {
        ParkingBoy parkingBoy = new ParkingBoy();

        Car car = new Car();
        Ticket ticket = parkingBoy.parkACar(car);
        Assert.assertEquals("Not enough position.",parkingBoy.getErrorMsg());

    }




}
