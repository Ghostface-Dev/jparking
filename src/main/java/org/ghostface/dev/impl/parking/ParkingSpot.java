package org.ghostface.dev.impl.parking;

import org.ghostface.dev.core.ParkingClient;

import org.ghostface.dev.parking.Spot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

public class ParkingSpot implements Spot {

    private final @Range(from = 1, to = Long.MAX_VALUE) int id;
    private @Nullable ParkingClient client;
    private @NotNull Status status;

    public ParkingSpot(@Range(from = 1, to = Long.MAX_VALUE) int id) {
        this.id = id;
        this.status = Status.AVAILABLE;
    }

    @Override
    public @Range(from = 1, to = Long.MAX_VALUE) int getId() {
        return id;
    }

    @Override
    public boolean isAvailable() {
        return status == Status.AVAILABLE;
    }

    @Override
    public @Nullable ParkingClient getClient() {
        return client;
    }

    @Override
    public @NotNull Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(@NotNull Status status) {
        this.status = status;
    }

    public void setClient(@Nullable ParkingClient client) {
        this.client = client;
    }

}
