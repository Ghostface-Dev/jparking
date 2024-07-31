package org.ghostface.dev.impl;

import org.ghostface.dev.core.Automobile.*;
import org.ghostface.dev.core.Entities;
import org.ghostface.dev.core.Person.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.Objects;

public class Client extends Entities implements ParkingAttendee {

    private final @NotNull String name;
    private final @NotNull String cpf;
    private @NotNull String email;
    private @NotNull Vehicle vehicle;

    public Client(@Range(from = 1, to = Long.MAX_VALUE) int id, @NotNull String name, @NotNull String email, @NotNull String cpf, @NotNull Vehicle vehicle) {
        super(id);
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.vehicle = vehicle;
        vehicle.setClient(this);
    }

    // statics

    public static void setEmail(@NotNull Client client, @NotNull String email) {
        client.setEmail(email);
    }

    public static void setVehicle(@NotNull Client client, @NotNull Vehicle vehicle) {
        if (vehicle.getClient() != null) {
            System.err.println("Vehicle " + vehicle.getName() + " already has an owner");
        } else {
            // old vehicle
            client.getVehicle().setClient(null);
            // new vehicle
            client.setVehicle(vehicle);
        }
    }

    // getters

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

    public final @NotNull Vehicle getVehicle() {
        return vehicle;
    }

    // setters

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public final void setVehicle(@NotNull Vehicle vehicle) {
        if (vehicle.getClient() != null) {
            System.err.println("Vehicle " + vehicle.getName() + " already has an owner: " + vehicle.getClient().getName());
            return;
        }
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        @NotNull Client client = (Client) object;
        return Objects.equals(name, client.name) && Objects.equals(email, client.email) && Objects.equals(cpf, client.cpf) && Objects.equals(vehicle, client.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, email, cpf, vehicle);
    }
}
