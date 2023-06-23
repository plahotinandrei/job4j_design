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
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public VehicleType getType() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
