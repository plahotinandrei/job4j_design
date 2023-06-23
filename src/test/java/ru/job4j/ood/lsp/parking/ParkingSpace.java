package ru.job4j.ood.lsp.parking;

public interface ParkingSpace {

    VehicleType getType();

    boolean isAvailable();

    boolean parkVehicle(Vehicle vehicle);

    Vehicle getParkedVehicle();
}
