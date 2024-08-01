package org.ghostface.dev.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.ghostface.dev.core.ParkedVehicle;
import org.ghostface.dev.core.ParkingClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.text.DateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Client extends ParkingClient {

    private @NotNull Vehicle vehicle;
    private final @NotNull String date;
    private final @NotNull String name;
    private @NotNull String email;
    private final @NotNull String cpf;

    public Client(@Range(from = 1, to = Long.MAX_VALUE) int id, @NotNull String name, @NotNull String cpf, @NotNull String email, @NotNull Vehicle vehicle) {
        super(id);
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.vehicle = vehicle;
        vehicle.setOwner(this);
        @NotNull DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.date = String.valueOf(OffsetDateTime.now().format(format));
    }

    @Override
    public @Nullable ParkedVehicle getVehicle() {
        return vehicle;
    }

    @Override
    public @NotNull String getDate() {
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

    public @NotNull JsonObject serialize() {
        JsonObject obj = new JsonObject();
        obj.addProperty("id", getId());
        obj.addProperty("name", this.name);
        obj.addProperty("email", this.email);
        obj.addProperty("cpf", this.cpf);
        obj.addProperty("date", this.date);

        JsonObject obj2 = new JsonObject();
        obj2.addProperty("name", this.vehicle.getName());
        obj2.addProperty("brand", this.vehicle.getBrand());
        obj2.addProperty("color", this.vehicle.getColor());
        obj2.addProperty("plate", this.vehicle.getPlate());
        obj2.addProperty("date", this.vehicle.getDate());
        obj.add("vehicle",obj2);

        return obj;
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

    @Override
    public boolean equals(@Nullable Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        @NotNull Client client = (Client) object;
        return Objects.equals(vehicle, client.vehicle) && Objects.equals(email, client.email) && Objects.equals(cpf, client.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vehicle, email, cpf);
    }

    @Override
    public String toString() {
        return "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
