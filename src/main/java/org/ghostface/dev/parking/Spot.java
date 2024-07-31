package org.ghostface.dev.parking;

import org.ghostface.dev.core.Person.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

public interface Spot {

    @Range(from = 1, to = Long.MAX_VALUE) int getId();

    boolean isAvailable();

    @Nullable ParkingClient getClient();

    @NotNull Status getStatus();

    void setStatus(@NotNull Status status);

    void setClient(@Nullable ParkingClient client);

    enum Status {
        AVAILABLE, BUSY
    }

}
