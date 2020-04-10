package com.oocl;

import java.io.CharArrayReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ParkingBoy {

    private String ErrorMsg;
    private Ticket ticket;
    private ArrayList<ParkingLot> parkingLotList;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLotList = new ArrayList<>();
        this.parkingLotList.add(parkingLot);
    }
    public ParkingBoy() {
        this(new ParkingLot());
    }

    public ArrayList<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(ArrayList<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public String getErrorMsg() {
        return ErrorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        ErrorMsg = errorMsg;
    }

    public Ticket parkACar(Car car) {
        ParkingLot parkingLot = findAbleParkingLot();       //check if available lots
        if(car.isParked()){
            throw new RuntimeException();
        }else if(car == null){
            throw new RuntimeException();
        }else{
            parkingLot.park(car);
            return new Ticket(car.hashCode());
        }
    }

    public Car fetchACar(Ticket ticket) {
        if (ticket == null) {
            this.setErrorMsg( "Please provide your parking ticket.");
            return null;
        }
        for (ParkingLot parkingLot : parkingLotList) {
            for (Car car : parkingLot.getCars()) {
                if (car.hashCode() == ticket.getCode()) {
                    parkingLot.removeCar(car);
                    return car;
                }
            }
        }
        this.setErrorMsg("Unrecognized parking ticket.");
        return null;
    }

    public ArrayList<Ticket> parkMultiplyCars(ArrayList<Car> carList) {
        int countOfCar = carList.size();
        for(int j = 0; j < countOfCar;j++) {
            for(int i = 0 ;i < parkingLotList.size();i++ ){
                if (parkingLotList.get(i).getRemainingCount() > 0){
                    parkingLotList.get(i).setParkedCarCount();
                    this.parkACar(carList.get(j));
                    break;
                }
            }
        }
        if(countOfCar > 0){
            this.checkParkingLotStatus(getParkingLotList().get(0));
        }
        return ParkingLot.getTickets(carList);
    }


    public boolean checkTicket(Ticket ticket) {
        if(ticket == null){
            this.setErrorMsg("Please provide your parking ticket.");
            return false;
        }
        else if(ticket.isProvided() == true && ticket.isUsed() == false){
            return true;
        }else{
            return  false;
        }
    }

    public Boolean checkParkingLotStatus(ParkingLot parkingLot) {
        if(parkingLot.isFulled){
            this.setErrorMsg("Not enough position.");
            return true;
        }else{
            return false;
        }

    }

    public int[] getParkingLotCount() {
        int[] arr = new int[parkingLotList.size()];
        for(int i = 0 ;i < parkingLotList.size();i++ ){
            arr[i] = getParkingLotList().get(i).getParkedCarCount();
        }
        return arr;
    }

    protected Ticket parkACarToSpecifyParkingLot(Car car) {
        return new Ticket();
    }

  /*  public void passErrorMsgToManager(String errorMsg, ServiceManager serviceManager) {
        serviceManager.setErrorMsg(errorMsg);
    }*/
    public ParkingLot findAbleParkingLot() {
        for(ParkingLot parkingLot : parkingLotList) {
            if (!parkingLot.isFull()) {
                return parkingLot;
            }
        }
        return null;
    }

}
