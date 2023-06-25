package ru.job4j.ood.lsp.parking;

import java.util.List;

public class OpenParking implements Parking {

    private final List<ParkingSpace> parkingSpaces;

    public OpenParking(List<ParkingSpace> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    @Override
    public List<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        boolean rsl = false;
        for (ParkingSpace space:parkingSpaces) {
            if (space.isAvailable() && !space.isStandard()) {
                rsl = space.parkVehicle(vehicle);
                break;
            }
        }
        if (!rsl) {
            List<ParkingSpace> spaces = findFreeStandardSpacesSuccession(parkingSpaces, vehicle.getSize());
            spaces.forEach(space -> space.parkVehicle(vehicle));
            rsl = !spaces.isEmpty();
        }
        return rsl;
    }

    private List<ParkingSpace> findFreeStandardSpacesSuccession(List<ParkingSpace> spaces, int size) {
        List<ParkingSpace> rsl = List.of();
        int start = 0;
        int end = 0;
        for (ParkingSpace space:spaces) {
            if (space.isStandard() && space.isAvailable()) {
                end++;
                if (end - start == size) {
                    rsl = spaces.subList(start, end);
                    break;
                }
            } else {
                end++;
                start = end;
            }
        }
        return rsl;
    }
}
