package com.parkinglotsystem;

import java.util.*;

public class ParkingLotSystem {
    private int actualCapacity;
    private List vehicles;
    private ParkingLotOwner owner;

    public ParkingLotSystem(int capacity) {
        this.vehicles = new ArrayList();
        this.actualCapacity = capacity;
    }

    public void registerOwner(ParkingLotOwner owner) {
        this.owner = owner;
    }

    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    public void park(Object vechile) throws ParkingLotException {
        if (this.vehicles.size() == this.actualCapacity) {
            owner.capacityIsFull();
            throw new ParkingLotException("Parking Lot Is Full");
        }
        if(isVechileParked(vechile))
            throw new ParkingLotException("Vehicle Already Parked");
        this.vehicles.add(vechile);
    }

    public boolean isVechileParked(Object vechile) {
        return this.vehicles.contains(vechile);
    }

    public boolean unPark(Object vechile) throws ParkingLotException {
        if (vechile == null) return false;
        if (this.vehicles.contains(vechile)) {
            this.vehicles.remove(vechile);
            return true;
        }
        return false;
    }
}