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
        boolean ticketIsUsed = false;

        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        Car returnedCar = parkingLot.fetch(ticket,ticketIsUsed);

        Assert.assertNotNull(returnedCar);
    }

    @Test
    public void should_fetch_correct_car_when_park_multiple_cars() {
        ParkingLot parkingLot = new ParkingLot();
        boolean ticketIsUsed = false;

        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        Ticket ticket3 = parkingLot.park(car3);

        Car returnedCar1 = parkingLot.fetch(ticket1,ticketIsUsed);
        Car returnedCar2 = parkingLot.fetch(ticket2,ticketIsUsed);
        Car returnedCar3 = parkingLot.fetch(ticket3,ticketIsUsed);

        System.out.println(ticket1);

        Assert.assertEquals(car1, returnedCar1);
        Assert.assertEquals(car2, returnedCar2);
        Assert.assertEquals(car3, returnedCar3);
    }

    @Test
    public void should_fetch_correct_car_when_fetch_correct_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        boolean ticketIsUsed = false;

        Car car = new Car();
        Ticket ticket = parkingLot.park(car);       //return ticket after parked

        System.out.println(ticket);

        Car returnedCar = parkingLot.fetch(ticket,ticketIsUsed);     //return corresponding car with ticket

        System.out.println(returnedCar);
      //  System.out.println(returnedCar + "  " + car);     // compare returned car and parked car

        Assert.assertEquals(car, returnedCar);
    }

    @Test
    public void no_car_fetched_when_wrong_or_no_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        boolean ticketIsUsed = false;

        Car car = new Car();
        Ticket ticket = parkingLot.park(car);       //return ticket after parked

        Car returnedCar = parkingLot.fetch(new Ticket(),ticketIsUsed);     //no returned car when wrong/ no ticket

        System.out.println(returnedCar);                      // no car returned if wrong/no ticket

        Assert.assertNull(returnedCar);
    }

    @Test
    public void no_car_fetched_when_ticket_used() {
        ParkingLot parkingLot = new ParkingLot();
        boolean ticketIsUsed = true;

        Car car = new Car();
        Ticket ticket = parkingLot.park(car);       //return ticket after parked

        System.out.println(ticket);

        Car returnedCar = parkingLot.fetch(ticket,ticketIsUsed);     //returned car by ticket
        System.out.println(car);
        System.out.println(returnedCar);

        Assert.assertNull(returnedCar);
    }

    @Test
    public void no_ticket_given_when_parking_lot_full() {
        ParkingLot parkingLot = new ParkingLot();
        boolean ticketIsUsed = false;

        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        Ticket ticket3 = parkingLot.park(car3);

        Car returnedCar1 = parkingLot.fetch(ticket1,ticketIsUsed);
        Car returnedCar2 = parkingLot.fetch(ticket2,ticketIsUsed);
        Car returnedCar3 = parkingLot.fetch(ticket3,ticketIsUsed);

        System.out.println(ticket1 + "   " + car1 + "  " + returnedCar1);
        System.out.println(ticket2 + "   " + car2 + "  " + returnedCar2);
        System.out.println(ticket3 + "   " + car3 + "  " + returnedCar3);

        Assert.assertNull(ticket3);

    }

    @Test (expected = UnrecognizedOrNoTicket.class)
    public void return_error_if_wrong_ticket_received() {
        ParkingLot parkingLot = new ParkingLot();
        boolean ticketIsUsed = false;

        Car car = new Car();

        Ticket ticket = parkingLot.park(car);

        Car returnedCar = parkingLot.fetch(new Ticket(),ticketIsUsed);

        System.out.println(car);
        System.out.println(ticket);
        System.out.println(returnedCar);

    }

    @Test (expected = UnrecognizedOrNoTicket.class)
    public void return_error_if_no_ticket_received() {
        ParkingLot parkingLot = new ParkingLot();
        boolean ticketIsUsed = false;

        Car car = new Car();

        Ticket ticket = parkingLot.park(car);
        Car returnedCar = parkingLot.fetch(new Ticket(),ticketIsUsed);

        System.out.println(car);
        System.out.println(ticket);
        System.out.println(returnedCar);

       // System.out.println(Exceptions.class);

    }

    @Test (expected = NotEnoughPosition.class)
    public void return_error_if_parking_position_not_enough() {
        ParkingLot parkingLot = new ParkingLot();
        boolean ticketIsUsed = false;

        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        Ticket ticket3 = parkingLot.park(car3);

        Car returnedCar1 = parkingLot.fetch(ticket1,ticketIsUsed);
        Car returnedCar2 = parkingLot.fetch(ticket2,ticketIsUsed);
        Car returnedCar3 = parkingLot.fetch(ticket3,ticketIsUsed);

        System.out.println(car1 + "  " + ticket1 + "  " + returnedCar1);
        System.out.println(car2 + "  " + ticket2 + "  " + returnedCar2);
        System.out.println(car3 + "  " + ticket3 + "  " + returnedCar3);

    }

    @Test
    public void park_to_second_park_if_first_park_full() {
        ParkingLot parkingLot = new ParkingLot();
        boolean ticketIsUsed = false;

        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);
        Ticket ticket3 = parkingLot.park(car3);

        Car returnedCar1 = parkingLot.fetch(ticket1,ticketIsUsed);
        Car returnedCar2 = parkingLot.fetch(ticket2,ticketIsUsed);
        Car returnedCar3 = parkingLot.fetch(ticket3,ticketIsUsed);

        System.out.println(car1 + "  " + ticket1 + "  " + returnedCar1);
        System.out.println(car2 + "  " + ticket2 + "  " + returnedCar2);
        System.out.println(car3 + "  " + ticket3 + "  " + returnedCar3);

    }
}
