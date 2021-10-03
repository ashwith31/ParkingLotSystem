package com.parkinglotsystem;

import org.junit.jupiter.api.*;

public class ParkingLotTest {
    Object vechile;
    ParkingLotSystem parkingLotSystem;

    @BeforeEach
    void setUp() {
        vechile = new Object();
        parkingLotSystem = new ParkingLotSystem(1);
    }

    @Test
    void givenAVechicle_WhenParked_ShouldReturnTrue() {
        try {
            parkingLotSystem.park(vechile);
            boolean isparked = parkingLotSystem.isVechileParked(vechile);
            Assertions.assertTrue(isparked);
        } catch (ParkingLotException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenAVechile_WhenAlreadyParked_Should_ReturnFalse() {
        try {
            parkingLotSystem.park(vechile);
            parkingLotSystem.park(new Object());
        } catch (ParkingLotException e) {
            Assertions.assertEquals("Parking Lot Is Full", e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void givenWhenParkingLotIsFull_ShouldInformTheOwner(){
        ParkingLotOwner owner = new ParkingLotOwner();
        parkingLotSystem.registerOwner(owner);
        try {
            parkingLotSystem.park(vechile);
            parkingLotSystem.park(new Object());
        } catch (ParkingLotException e) {        }
        boolean capacityFull = owner.isCapacityFull();
        Assertions.assertTrue(capacityFull);
    }

    @Test
    public void givenCapacityIs2_ShouldAbleToPark2Vehicles(){
        Object vehicle2 = new Object();
        parkingLotSystem.setCapacity(2);
        try {
            parkingLotSystem.park(vechile);
            parkingLotSystem.park(vehicle2);
            boolean isparked1 = parkingLotSystem.isVechileParked(vechile);
            boolean isparked2 = parkingLotSystem.isVechileParked(vehicle2);
            Assertions.assertTrue(isparked1 && isparked2);
        } catch (ParkingLotException e) {        }

    }
}

