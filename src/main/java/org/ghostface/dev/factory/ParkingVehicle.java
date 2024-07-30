package org.ghostface.dev.factory;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Objects;


public abstract non-sealed class ParkingVehicle implements VehicleFactory, Serializable {

    private final long id;

    public ParkingVehicle(long id) {
        this.id = id;
    }

    @Override
    public final long getId() {
        return id;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        @NotNull ParkingVehicle that = (ParkingVehicle) object;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
