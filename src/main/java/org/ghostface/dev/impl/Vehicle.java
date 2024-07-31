package org.ghostface.dev.impl;

import org.ghostface.dev.core.Automobile.*;
import org.ghostface.dev.core.Entities;

import org.ghostface.dev.core.Person.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.time.OffsetDateTime;


public class Vehicle extends Entities implements ParkedVehicle {

    private @Nullable ParkingClient owner;
    private final @NotNull OffsetDateTime date;
    private final @NotNull String plate;
    private final @NotNull String name;
    private final @NotNull String brand;
    private @NotNull String color;

    public Vehicle(@Range(from = 1, to = Long.MAX_VALUE) int id, @NotNull String plate, @NotNull String name, @NotNull String brand, @NotNull String color) {
        super(id);
        this.plate = plate;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.date = OffsetDateTime.now();
    }

    @Override
    public @Nullable ParkingClient getOwner() {
        return owner;
    }

    @Override
    public @NotNull OffsetDateTime getDate() {
        return date;
    }

    @Override
    public final void setOwner(@NotNull ParkingClient owner) {
        this.owner = owner;
        owner.setVehicle(this);
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
    public @NotNull String getName() {
        return name;
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
