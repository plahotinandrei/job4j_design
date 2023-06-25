package ru.job4j.ood.lsp.parking;

public interface ParkingSpace {

    boolean isAvailable();

    boolean parkVehicle(Vehicle vehicle);

    boolean isStandard();

    Vehicle getParkedVehicle();
}
