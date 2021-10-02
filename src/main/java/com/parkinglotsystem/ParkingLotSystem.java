package com.parkinglotsystem;

public class ParkingLotSystem {
    private int actualCapacity;
    private int currentCapacity;
    private Object vechile;
    private ParkingLotOwner owner;

    public ParkingLotSystem(int capacity) {
        this.currentCapacity = 0;
        this.actualCapacity = capacity;
    }

    public void registerOwner(ParkingLotOwner owner) {
        this.owner = owner;
    }

    public void setCapacity(int capacity) {
        this.actualCapacity = capacity;
    }

    public void park(Object vechile) throws ParkingLotException {
        if (this.currentCapacity == this.actualCapacity) {
            owner.capacityIsFull();
            throw new ParkingLotException("Parking Lot Is Full");
        }
        this.currentCapacity++;
        this.vechile = vechile;
    }

    public boolean isVechileParked(Object vechile) {
        return this.vechile.equals(vechile);
    }

    public boolean unPark(Object vechile) throws ParkingLotException {
        if (this.vechile == null) return false;
        if (this.vechile.equals(vechile)) {
            this.vechile = null;
            return true;
        }
        return false;
    }

    public boolean isVechileUnParked(Object vechile) {
        return this.vechile == null;
    }

    public boolean isFull() {
        return this.vechile != null;
    }
}