package ru.job4j.ood.lsp.parking;

public class SpaceForCar implements ParkingSpace {

    private final VehicleType type = VehicleType.CAR;
    private boolean available = true;
    private Vehicle parkedVehicle;

    @Override
    public VehicleType getType() {
        return type;
    }

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
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
