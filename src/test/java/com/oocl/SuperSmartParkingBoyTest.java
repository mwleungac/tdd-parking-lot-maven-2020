package com.oocl;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SuperSmartParkingBoyTest {
    @Test
    public void should_get_parking_lot_status_when_have_two_parking_lot_and_super_smarted_parkinng_boy() {
        //Given
        //Given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        ArrayList<Car> carList = new ArrayList<>(Arrays.asList(new Car(), new Car(),new Car()));
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        superSmartParkingBoy.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        //When
        superSmartParkingBoy.parkMultiplyCars(carList);
        int actuallyParkingLotStatus[] =  superSmartParkingBoy.getParkingLotCount();
        int exceptedParkingLotStatus[] = {1,2};
        // Then
        Assert.assertArrayEquals(exceptedParkingLotStatus,actuallyParkingLotStatus);
    }
}
