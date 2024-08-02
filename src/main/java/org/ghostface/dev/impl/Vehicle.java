package org.ghostface.dev.impl;

import org.ghostface.dev.factory.VehicleFactory;
import org.ghostface.dev.vehicle.Brand;
import org.ghostface.dev.vehicle.Plate;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class Vehicle implements VehicleFactory {

    private final @NotNull String model;
    private final @NotNull String brand;
    private final @NotNull String plate;
    private @NotNull String color;

    public Vehicle(@NotNull String model, @NotNull Brand brand, @NotNull Plate plate, @NotNull String color) {
        this.model = model;
        this.brand = brand.brand;
        this.plate = plate.plate;
        this.color = color.toLowerCase();
    }

    @Override
    public @NotNull String getModel() {
        return model;
    }

    @Override
    public @NotNull String getBrand() {
        return brand;
    }

    @Override
    public @NotNull String getPlate() {
        return plate;
    }

    @Override
    public @NotNull String getColor() {
        return color;
    }

    @Override
    public void setColor(@NotNull String color) {
        this.color = color;
    }

}
