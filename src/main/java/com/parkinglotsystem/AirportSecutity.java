package com.parkinglotsystem;

public class AirportSecutity implements ParkingLotObserver{
    private boolean isFullCapacity;

    public void capacityIsFull() {
        isFullCapacity = true;
    }

    public boolean isCapacityFull() {
        return this.isFullCapacity;
    }
}
