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



}
