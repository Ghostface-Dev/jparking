package org.ghostface.dev.parking;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface Parking {

    void reserveSpot();

    void relesaseSpot();

    @NotNull Set<@NotNull Integer> spotsAvailable();

    @NotNull Set<@NotNull Integer> spotsOccuped();



}
