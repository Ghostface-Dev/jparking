package org.ghostface.dev.core;

import org.jetbrains.annotations.NotNull;

public interface Person {

    @NotNull String getName();

    @NotNull String getEmail();

    @NotNull String getCpf();

    void setEmail(@NotNull String email);

    interface ParkingAttendee extends Person {

        @NotNull Automobile getVehicle();

    }
}
