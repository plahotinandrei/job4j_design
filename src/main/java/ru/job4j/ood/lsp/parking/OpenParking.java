package ru.job4j.ood.lsp.parking;

import java.util.List;

public class OpenParking implements Parking {

    private List<ParkingSpace> parkingSpaces;

    public OpenParking(List<ParkingSpace> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    @Override
    public List<ParkingSpace> getParkingSpaces() {
        return null;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        return false;
    }
}
