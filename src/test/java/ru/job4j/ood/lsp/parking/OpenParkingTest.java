package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class OpenParkingTest {

    @Test
    public void when2TruckAnd1CarAnd5SpacesThenAllParked() {
        ParkingSpace space1 = new SpaceForCar();
        ParkingSpace space2 = new SpaceForTruck();
        ParkingSpace space3 = new SpaceForCar();
        ParkingSpace space4 = new SpaceForCar();
        ParkingSpace space5 = new SpaceForCar();
        Parking parking = new OpenParking(List.of(space1, space2, space3, space4, space5));
        Vehicle vehicle1 = new Truck("A222CB12", "KIA", 2);
        Vehicle vehicle2 = new Truck("B412EY43", "Honda", 3);
        Vehicle vehicle3 = new Car("M684BC94", "Toyota");
        parking.parkVehicle(vehicle1);
        parking.parkVehicle(vehicle2);
        parking.parkVehicle(vehicle3);
        List<ParkingSpace> spaces = parking.getParkingSpaces();
        assertThat(spaces.get(0).getParkedVehicle()).isEqualTo(vehicle3);
        assertThat(spaces.get(1).getParkedVehicle()).isEqualTo(vehicle1);
        assertThat(spaces.get(2).getParkedVehicle()).isEqualTo(vehicle2);
        assertThat(spaces.get(3).getParkedVehicle()).isEqualTo(vehicle2);
        assertThat(spaces.get(4).getParkedVehicle()).isEqualTo(vehicle2);
    }

    @Test
    public void when2TruckAnd2SpacesThen1TruckParked2TrackNotParked() {
        ParkingSpace space1 = new SpaceForCar();
        ParkingSpace space2 = new SpaceForTruck();
        Parking parking = new OpenParking(List.of(space1, space2));
        Vehicle vehicle1 = new Truck("A222CB12", "KIA", 2);
        Vehicle vehicle2 = new Truck("B412EY43", "Honda", 3);
        boolean isParked1 = parking.parkVehicle(vehicle1);
        boolean isParked2 = parking.parkVehicle(vehicle2);
        assertThat(isParked1).isTrue();
        assertThat(isParked2).isFalse();
    }
}