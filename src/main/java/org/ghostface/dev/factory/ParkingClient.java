package org.ghostface.dev.factory;

import org.ghostface.dev.imp.Vehicle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Objects;

public abstract non-sealed class ParkingClient implements UserFactory, Serializable {

    private final long id;

    public ParkingClient(long id) {
        this.id = id;
    }

    public final long getId() {
        return id;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        @NotNull ParkingClient that = (ParkingClient) object;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
