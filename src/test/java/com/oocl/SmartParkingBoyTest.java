package com.oocl;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SmartParkingBoyTest {
    @Test
    public void should_get_parking_lot_status_when_have_two_parking_lot_and_smarted_parkinng_boy() {
        //Given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ArrayList<Car> carList = new ArrayList<>(Arrays.asList(new Car(), new Car(),new Car()));
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        smartParkingBoy.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        //When
        smartParkingBoy.parkMultiplyCars(carList);
        int actuallyParkingLotStatus[] =  smartParkingBoy.getParkingLotCount();
        int exceptedParkingLotStatus[] = {1,2};
        // Then
        Assert.assertArrayEquals(exceptedParkingLotStatus,actuallyParkingLotStatus);
    }
}
