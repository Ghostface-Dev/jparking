package org.ghostface.dev.core;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

public abstract class ParkedVehicle implements Automobile, Serializable {

    private final @Range(from = 1, to = Long.MAX_VALUE) int id;

    public ParkedVehicle(@Range(from = 1, to = Long.MAX_VALUE) int id) {
        this.id = id;
    }

    public final @Range(from = 1, to = Long.MAX_VALUE) int getId() {
        return id;
    }

    public abstract @Nullable ParkingClient getOwner();

    public abstract @NotNull OffsetDateTime getDate();

    @Override
    public boolean equals(@Nullable Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        @NotNull ParkedVehicle that = (ParkedVehicle) object;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
