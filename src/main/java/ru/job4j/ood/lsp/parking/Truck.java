package ru.job4j.ood.lsp.parking;

public class Truck implements Vehicle {

    private final String regNumber;
    private final String name;
    private final VehicleType type = VehicleType.TRUCK;
    private final int size;

    public Truck(String regNumber, String name, int size) {
        this.regNumber = regNumber;
        this.name = name;
        this.size = size;
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
