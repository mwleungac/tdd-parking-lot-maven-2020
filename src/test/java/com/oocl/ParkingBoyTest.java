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
        Ticket ticket = parkingBoy.parkACar(new Car());
        Car car = parkingBoy.fetchACar(ticket);
        Assert.assertNotNull(car);
    }

    @Test
    public void should_park_multiply_cars() {

        ParkingBoy parkingBoy = new ParkingBoy();
        ArrayList<Car> carList = new ArrayList<>();
        Assert.assertEquals(new ArrayList<Ticket>(),parkingBoy.parkMultiplyCars(carList));
    }

    @Test
    public void should_fetch_right_car_when_using_correspond_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car carA = new Car();
        Car carB = new Car();
        Ticket ticketA = parkingBoy.parkACar(carA);
        Ticket ticketB = parkingBoy.parkACar(carB);
        //When
        Car carAA = parkingBoy.fetchACar(ticketA);
        Car carBB = parkingBoy.fetchACar(ticketB);
        // Then
        Assert.assertEquals(carA,carAA);
        Assert.assertEquals(carB,carBB);
    }

    @Test
    public void should_fetch_no_car_when_give_a_wrong_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket(false,false);

        //When
        boolean isValidTicket = parkingBoy.checkTicket(ticket);
        // Then
        Assert.assertEquals(null,parkingBoy.fetchACar(ticket));
    }

    @Test
    public void should_fetch_no_car_when_dose_provide_a_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = null;
        //When&Then
        Assert.assertEquals(false, parkingBoy.checkTicket(ticket));
    }

    @Test
    public void should_not_park_a_car_when_parking_lot_have_no_position() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(10,10);
        Car car = new Car();
        //When
        boolean isCapacityFulled = parkingLot.isCapacityFulled();
        // Then
        Assert.assertEquals(null,isCapacityFulled?null:parkingBoy.parkACar(car));
    }

    @Test
    public void should_throw_park_a_car_when_Passing_a_parked_car() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        car.setParked(true);
        //When&Then
        Assert.assertThrows(RuntimeException.class, ()-> { parkingBoy.parkACar(car); });
    }

    @Test
    public void should_throw_park_a_car_when_Passing_null_car() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = null;
        //When&Then
        Assert.assertThrows(RuntimeException.class, ()-> { parkingBoy.parkACar(car); });
    }

    @Test
    public void should_get_error_msg_when_give_a_wrong_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket(true,false);
        //When
        boolean isValidTicket = parkingBoy.checkTicket(ticket);
        parkingBoy.fetchACar(ticket);
        String errorMsg = parkingBoy.getErrorMsg();
        // Then

        Assert.assertEquals("Unrecognized parking ticket.",errorMsg);
    }

    @Test
    public void should_get_error_msg_when_dose_provide_a_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = null;
        //When
        parkingBoy.checkTicket(ticket);
        String errorMsg = parkingBoy.getErrorMsg();
        // Then

        Assert.assertEquals("Please provide your parking ticket.",errorMsg);
    }

    @Test
    public void should_get_parking_lot_count_when_have_two_parking_lot_and_not_smarted_parkinng_boy() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ArrayList<Car> carList = new ArrayList<>(Arrays.asList(new Car(), new Car(),new Car()));
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        parkingBoy.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        //When
        parkingBoy.parkMultiplyCars(carList);
        int actuallyParkingLotStatus[] =  parkingBoy.getParkingLotCount();
        int exceptedParkingLotStatus[] = {2,1};
        // Then
        Assert.assertArrayEquals(exceptedParkingLotStatus,actuallyParkingLotStatus);
    }



}
