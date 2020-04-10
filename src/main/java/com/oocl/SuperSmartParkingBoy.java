package com.oocl;

import java.util.ArrayList;

public class SuperSmartParkingBoy extends ParkingBoy {
    @Override
    public ArrayList<Ticket> parkMultiplyCars(ArrayList<Car> carList) {
        double valueTemp;
        int keyTemp = 0;
        for(int j = 0; j < carList.size();j++) {
            valueTemp = 0;
            for (int i = 0; i < this.getParkingLotList().size(); i++) {
                if(valueTemp < getAvailableCapacity(i)){
                    valueTemp = (getAvailableCapacity(i));
                    keyTemp = i;
                }
            }
            if(valueTemp > 0){
                this.getParkingLotList().get(keyTemp).setParkedCarCount();
                this.parkACar(carList.get(j));
            }else{
                this.checkParkingLotStatus(getParkingLotList().get(keyTemp));
            }
        }

        return ParkingLot.getTickets(carList);
    }

    private double getAvailableCapacity(int i) {
        return this.getParkingLotList().get(i).getRemainingCount() * 1.0 / this.getParkingLotList().get(i).getCapacity();
    }
}
