package org.ghostface.dev.impl;

import org.ghostface.dev.parking.Spot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

public class SpotImpl implements Spot {

    private final @Range(from = 1, to = Long.MAX_VALUE) long id;
    private @NotNull Status status;
    private @Nullable Client client;
    private @Nullable Vehicle vehicle;

    public SpotImpl(@Range(from = 1, to = Long.MAX_VALUE) long id) {
        this.id = id;
        this.status = Status.AVAILABLE;
    }

    @Override
    public @Range(from = 1, to = Long.MAX_VALUE) long getId() {
        return id;
    }

    public @Nullable Client getClient() {
        return this.client;
    }

    public @Nullable Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public boolean isAvailable() {
        return status == Status.AVAILABLE;
    }

    @Override
    public @NotNull Status getStatus() {
        return status;
    }

    final void setStatus(@NotNull Status status) {
        this.status = status;
    }

    public void setClient(@Nullable Client client) {
        this.client = client;
    }

    public void setVehicle(@Nullable Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
