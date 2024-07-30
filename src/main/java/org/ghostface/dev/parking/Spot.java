package org.ghostface.dev.parking;

import org.jetbrains.annotations.NotNull;

import org.jetbrains.annotations.Range;

public interface Spot {

    @Range(from = 1, to = Long.MAX_VALUE) long getId();

    boolean isAvailable();

    @NotNull Status getStatus();

    enum Status {
        AVAILABLE, BUSY
    }
}
