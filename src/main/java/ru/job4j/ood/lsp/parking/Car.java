package ru.job4j.ood.lsp.parking;

public class Car implements Vehicle {

    private final String regNumber;
    private final String name;
    private final VehicleType type = VehicleType.CAR;
    private final int size = 1;

    public Car(String regNumber, String name) {
        this.regNumber = regNumber;
        this.name = name;
    }

    @Override
    public String getRegNumber() {
        return regNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    @Override
    public int getSize() {
        return size;
    }
}
