package com.parkinglotsystem;

import org.junit.jupiter.api.*;

public class ParkingLotTest{
    Object vechile;
    ParkingLotSystem parkingLotSystem;

    @BeforeEach
    void setUp() {
        vechile = new Object();
        parkingLotSystem = new ParkingLotSystem();
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
    void givenAVechile_WhenUnparked_ShouldReturnTrue() {
        try {
            parkingLotSystem.park(vechile);
            boolean park = parkingLotSystem.isVechileParked(vechile);
            parkingLotSystem.unPark(vechile);
            boolean unPark = parkingLotSystem.isVechileUnParked(vechile);
            Assertions.assertEquals(park,unPark);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void givenAVechile_WhenAlreadyParked_Should_ReturnFalse() {
        try {
            parkingLotSystem.park(vechile);
            parkingLotSystem.park(new Object());
        } catch (ParkingLotException e) {
            Assertions.assertEquals("Parking Lot Is Full",e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void givenAVechile_WhenNotParked_ShouldNotBeUnparked() {
        try {
            parkingLotSystem.unPark(vechile);
            parkingLotSystem.isVechileUnParked(vechile);
        }catch(ParkingLotException e){
            Assertions.assertEquals("Unpark Is Not Possible",e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void givenParkingLot_WhenFull_ShouldReturnTrue() throws ParkingLotException {
        parkingLotSystem.park(vechile);
        boolean check = parkingLotSystem.isFull();
        Assertions.assertTrue(check);
    }

    @Test
    void givenParkingLot_WhenNotFull_ShouldReturnFalse() throws ParkingLotException {
        boolean check = parkingLotSystem.isFull();
        Assertions.assertFalse(check);
    }
}

