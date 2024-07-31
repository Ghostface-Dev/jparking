package org.ghostface.dev.core;

import org.jetbrains.annotations.NotNull;

import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

import org.ghostface.dev.core.Person.*;

public interface Automobile {

    @NotNull String getPlate();

    @NotNull String getBrand();

    @NotNull String getName();

    @NotNull String getColor();

    void setColor(@NotNull String color);

    interface ParkedVehicle extends Automobile {

        @Nullable ParkingClient getOwner();

        @NotNull OffsetDateTime getDate();

        void setOwner(@NotNull ParkingClient owner);

    }
}
