package org.ghostface.dev.factory;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.time.OffsetDateTime;

sealed interface VehicleFactory permits ParkingVehicle {

    @Nullable ParkingClient getClient();

    @NotNull String getPlate();

    @NotNull String getBrand();

    @NotNull String getColor();

    void setColor(@NotNull String color);

    @NotNull OffsetDateTime getDate();

}
