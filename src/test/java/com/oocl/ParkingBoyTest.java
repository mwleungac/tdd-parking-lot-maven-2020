package com.oocl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ParkingBoyTest {

    private ParkingLot[] parkingLotArray;
    private ParkingBoy parkingBoy;

    @Before
    public void beforeFunction() {
        parkingLotArray = new ParkingLot[1];
        parkingLotArray[0] = new ParkingLot();
        parkingBoy = new ParkingBoy(parkingLotArray);
    }

    @Test
    public void should_park_a_car_to_a_parking_lot_and_get_it_back() {
        beforeFunction();
        Car car = new Car();
        ParkingTicket ticket = parkingBoy.park(car);

        Car fetched = parkingBoy.fetch(ticket);

        Assert.assertEquals(fetched, car);
    }

    @Test
    public void should_park_multiple_cars_to_a_parking_lot_and_get_them_back() {
        beforeFunction();
        Car firstCar = new Car();
        Car secondCar = new Car();

        ParkingTicket firstTicket = parkingBoy.park(firstCar);
        ParkingTicket secondTicket = parkingBoy.park(secondCar);

        Car fetchedByFirstTicket = parkingBoy.fetch(firstTicket);
        Car fetchedBySecondTicket = parkingBoy.fetch(secondTicket);

        Assert.assertEquals(firstCar, fetchedByFirstTicket);
        Assert.assertEquals(secondCar, fetchedBySecondTicket);
    }

    @Test
    public void should_not_fetch_any_car_once_ticket_is_wrong() {
        beforeFunction();
        Car car = new Car();
        ParkingTicket wrongTicket = new ParkingTicket();

        ParkingTicket ticket = parkingBoy.park(car);

        Assert.assertNull(parkingBoy.fetch(wrongTicket));
        Assert.assertEquals(car, parkingBoy.fetch(ticket));
    }

    @Test
    public void should_query_message_once_the_ticket_is_wrong() {
        beforeFunction();
        ParkingTicket wrongTicket = new ParkingTicket();

        parkingBoy.fetch(wrongTicket);
        String message = parkingBoy.getLastErrorMessage();

        Assert.assertEquals("Unrecognized parking ticket.", message);
    }

    @Test
    public void should_not_fetch_any_car_once_ticket_is_not_provided() {
        beforeFunction();
        Car car = new Car();

        ParkingTicket ticket = parkingBoy.park(car);

        Assert.assertNull(parkingBoy.fetch(null));
        Assert.assertEquals(car, parkingBoy.fetch(ticket));
    }

    @Test
    public void should_query_message_once_ticket_is_not_provided() {
        beforeFunction();
        parkingBoy.fetch(null);

        Assert.assertEquals(
                "Please provide your parking ticket.",
                parkingBoy.getLastErrorMessage());
    }

    @Test
    public void should_not_fetch_any_car_once_ticket_has_been_used() {
        beforeFunction();
        Car car = new Car();

        ParkingTicket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);

        Assert.assertNull(parkingBoy.fetch(ticket));
    }

    @Test
    public void should_query_error_message_for_used_ticket() {
        beforeFunction();
        Car car = new Car();

        ParkingTicket ticket = parkingBoy.park(car);
        parkingBoy.fetch(ticket);
        parkingBoy.fetch(ticket);

        Assert.assertEquals(
                "Unrecognized parking ticket.",
                parkingBoy.getLastErrorMessage()
        );
    }
    @Test
    public void should_not_park_cars_to_parking_lot_if_there_is_not_enough_position() {
        final int capacity = 1;
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLotArray[0] = parkingLot;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);

        parkingBoy.park(new Car());

        Assert.assertNull(parkingBoy.park(new Car()));
    }

    @Test
    public void should_get_message_if_there_is_not_enough_position() {
        final int capacity = 1;
        ParkingLot[] parkingLotArray = new ParkingLot[1];
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLotArray[0] = parkingLot;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotArray);

        parkingBoy.park(new Car());
        parkingBoy.park(new Car());

        Assert.assertEquals("Not enough position.", parkingBoy.getLastErrorMessage());
    }

    

}
