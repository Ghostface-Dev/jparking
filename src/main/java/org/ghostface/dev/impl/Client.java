package org.ghostface.dev.impl;

import org.ghostface.dev.core.ParkedVehicle;
import org.ghostface.dev.core.ParkingClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.time.OffsetDateTime;

public class Client extends ParkingClient {

    private @Nullable Vehicle vehicle;
    private final @NotNull OffsetDateTime date;
    private final @NotNull String name;
    private @NotNull String email;
    private final @NotNull String cpf;

    public Client(@Range(from = 1, to = Long.MAX_VALUE) int id, @NotNull String name, @NotNull String cpf, @NotNull String email, @NotNull Vehicle vehicle) {
        super(id);
        this.date = OffsetDateTime.now();
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.vehicle = vehicle;
    }

    @Override
    public @Nullable ParkedVehicle getVehicle() {
        return vehicle;
    }

    @Override
    public @NotNull OffsetDateTime getDate() {
        return date;
    }

    public final void setVehicle(@NotNull Vehicle vehicle) {
        if (vehicle.getOwner() != null) {
            System.err.println("Vehicle: " + vehicle.getName() + " already has an owner: " + vehicle.getOwner().getName());
        } else {
            this.vehicle = vehicle;
            vehicle.setOwner(this);
        }
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public @NotNull String getEmail() {
        return email;
    }

    @Override
    public @NotNull String getCpf() {
        return cpf;
    }

    @Override
    public void setEmail(@NotNull String email) {
        this.email = email;
    }
}
