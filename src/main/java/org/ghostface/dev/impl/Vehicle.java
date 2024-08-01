package org.ghostface.dev.impl;


import com.google.gson.JsonObject;
import org.ghostface.dev.core.ParkedVehicle;
import org.ghostface.dev.core.ParkingClient;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;


public class Vehicle extends ParkedVehicle {

    private @Nullable Client owner;
    private final @NotNull String date;
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
        @NotNull DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.date = String.valueOf(OffsetDateTime.now().format(format));
    }

    public @NotNull JsonObject serialize() {
        JsonObject obj = new JsonObject();
        obj.addProperty("id", getId());
        obj.addProperty("name", this.name);
        obj.addProperty("brand", this.brand);
        obj.addProperty("color", this.color);
        obj.addProperty("plate", this.plate);
        obj.addProperty("date", this.date);

        if (this.owner != null) {
            JsonObject obj2 = new JsonObject();
            obj2.addProperty("id", this.owner.getId());
            obj2.addProperty("name", this.owner.getName());
            obj2.addProperty("email", this.owner.getEmail());
            obj2.addProperty("cpf", this.owner.getCpf());
            obj2.addProperty("date", this.owner.getDate());
            obj.add("owner", obj2);
        }

        return obj;
    }

    @Override
    public @Nullable ParkingClient getOwner() {
        return owner;
    }

    @Override
    public @NotNull String getDate() {
        return date;
    }

    public final void setOwner(@NotNull Client owner) {
        this.owner = owner;
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
