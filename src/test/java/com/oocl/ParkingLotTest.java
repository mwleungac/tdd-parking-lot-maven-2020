package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {

    @Test
    public void return_ticket_when_car_parked() {
        ParkingLot parkingLot = new ParkingLot();

        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        Assert.assertNotNull(ticket);
    }

    @Test
    public void return_car_when_ticket_received() {
        ParkingLot parkingLot = new ParkingLot();

        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        Car returnedCar = parkingLot.fetch(ticket);

        Assert.assertNotNull(returnedCar);
    }

    @Test
    public void should_fetch_correct_car_when_park_multiple_cars() {
        ParkingLot parkingLot = new ParkingLot();

        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        Ticket ticket3 = parkingLot.park(car3);

        Car returnedCar1 = parkingLot.fetch(ticket1);
        Car returnedCar2 = parkingLot.fetch(ticket2);
        Car returnedCar3 = parkingLot.fetch(ticket3);

        System.out.println(ticket1);

        Assert.assertEquals(car1, returnedCar1);
        Assert.assertEquals(car2, returnedCar2);
        Assert.assertEquals(car3, returnedCar3);
    }

    @Test
    public void should_fetch_correct_car_when_fetch_correct_ticket() {
        ParkingLot parkingLot = new ParkingLot();

        Car car = new Car();
        Ticket ticket = parkingLot.park(car);       //return ticket after parked

        Car returnedCar = parkingLot.fetch(ticket);     //return corresponding car with ticket

      //  System.out.println(returnedCar + "  " + car);     // compare returned car and parked car

        Assert.assertEquals(car, returnedCar);
    }

    @Test
    public void no_car_fetched_when_wrong_or_no_ticket() {
        ParkingLot parkingLot = new ParkingLot();

        Car car = new Car();
        Ticket ticket = parkingLot.park(car);       //return ticket after parked

        Car returnedCar = parkingLot.fetch(new Ticket());     //no returned car when wrong/ no ticket

        System.out.println(returnedCar);                      // no car returned if wrong/no ticket

        Assert.assertNull(returnedCar);
    }
}
