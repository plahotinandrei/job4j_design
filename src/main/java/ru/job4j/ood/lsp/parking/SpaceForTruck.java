package ru.job4j.ood.lsp.parking;

public class SpaceForTruck implements ParkingSpace {

    private boolean available = true;
    private Vehicle parkedVehicle;
    private final boolean isStandard = false;

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        boolean rsl = false;
        if (available && !vehicle.getType().equals(VehicleType.CAR)) {
            parkedVehicle = vehicle;
            rsl = true;
            available = false;
        }
        return rsl;
    }

    @Override
    public boolean isStandard() {
        return isStandard;
    }

    @Override
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}