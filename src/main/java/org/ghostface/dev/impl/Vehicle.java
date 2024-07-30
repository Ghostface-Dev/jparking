package org.ghostface.dev.impl;

import org.ghostface.dev.factory.ParkingClient;
import org.ghostface.dev.factory.ParkingVehicle;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.time.OffsetDateTime;

public class Vehicle extends ParkingVehicle {

    private @Nullable Client client;
    private final @NotNull String name;
    private final @NotNull String plate;
    private final @NotNull String brand;
    private @NotNull String color;
    private final @NotNull OffsetDateTime creationDate;

    public Vehicle(@Range(from = 1, to = Long.MAX_VALUE) long id, @NotNull String plate, @NotNull String name, @NotNull String brand, @NotNull String color) {
        super(id);
        this.plate = plate;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.creationDate = OffsetDateTime.now();
    }

    // getters

    @Override
    public @Nullable ParkingClient getClient() {
        return client;
    }

    @Override
    public @NotNull String getPlate() {
        return plate;
    }

    @Override
    public @NotNull String getBrand() {
        return brand;
    }

    @Override
    public @NotNull String getColor() {
        return color;
    }

    @Override
    public @NotNull OffsetDateTime getDate() {
        return creationDate;
    }

    public @NotNull String getName() {
        return name;
    }

    // setters

    @Override
    public void setColor(@NotNull String color) {
        this.color = color;
    }

    public void setClient(@NotNull Client client) {
        this.client = client;
    }

}
