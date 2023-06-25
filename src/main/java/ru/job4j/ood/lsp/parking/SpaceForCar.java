package ru.job4j.ood.lsp.parking;

public class SpaceForCar implements ParkingSpace {

    private boolean available = true;
    private Vehicle parkedVehicle;
    private final boolean isStandard = true;

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        boolean rsl = false;
        if (available) {
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
