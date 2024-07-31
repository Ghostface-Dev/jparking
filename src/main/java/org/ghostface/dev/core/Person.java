package org.ghostface.dev.core;

import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;

import org.ghostface.dev.core.Automobile.*;
import org.jetbrains.annotations.Nullable;

public interface Person {

    @NotNull String getName();

    @NotNull String getEmail();

    @NotNull String getCpf();

    void setEmail(@NotNull String email);

    interface ParkingClient extends Person {

        @Nullable ParkedVehicle getVehicle();

        @NotNull OffsetDateTime getDate();

        void setVehicle(@NotNull ParkedVehicle vehicle);

    }
}
