package org.ghostface.dev.core;

import org.jetbrains.annotations.NotNull;

import org.ghostface.dev.core.Person.*;
import org.jetbrains.annotations.Nullable;

public interface Automobile {

    @NotNull String getPlate();

    @NotNull String getBrand();

    @NotNull String getName();

    @NotNull String getColor();

    void setColor(@NotNull String color);

    interface ParkedVehicle extends Automobile {

        @Nullable ParkingAttendee getClient();

    }
}
