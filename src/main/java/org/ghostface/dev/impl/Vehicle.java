package org.ghostface.dev.impl;

import org.ghostface.dev.core.Automobile.*;
import org.ghostface.dev.core.Entities;

import org.ghostface.dev.core.Person;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.time.OffsetDateTime;


public class Vehicle extends Entities implements ParkedVehicle {

    private final @NotNull String plate;
    private final @NotNull String brand;
    private final @NotNull String name;
    private @NotNull String color;
    private @Nullable Client client;
    private final @NotNull OffsetDateTime date;

    public Vehicle(@Range(from = 1, to = Long.MAX_VALUE) int id, @NotNull String plate, @NotNull String brand, @NotNull String name, @NotNull String color) {
        super(id);
        this.plate = plate;
        this.brand = brand;
        this.name = name;
        this.color = color;
        this.date = OffsetDateTime.now();
    }

    //getters

    public final @NotNull OffsetDateTime getDate() {
        return date;
    }

    public final @Nullable Person.ParkingAttendee getClient() {
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

    public final void setClient(@Nullable Client client) {
        if (this.client != null) {
            System.err.println("Client has alread been defined by " + this.client.getName());
            return;
        }
        this.client = client;
    }

}
