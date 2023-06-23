package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Parking {

    List<ParkingSpace> getParkingSpaces();

    boolean parkVehicle(Vehicle vehicle);
}
