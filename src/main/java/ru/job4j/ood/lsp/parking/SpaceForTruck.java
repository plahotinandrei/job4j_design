package ru.job4j.ood.lsp.parking;

public class SpaceForTruck implements ParkingSpace {

    @Override
    public VehicleType getType() {
        return null;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public Vehicle getParkedVehicle() {
        return null;
    }
}
