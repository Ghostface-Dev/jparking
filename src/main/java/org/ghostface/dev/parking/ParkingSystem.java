package org.ghostface.dev.parking;

import org.ghostface.dev.factory.ParkingClient;
import org.ghostface.dev.impl.Client;
import org.jetbrains.annotations.NotNull;

import org.jetbrains.annotations.Range;

import java.util.Optional;
import java.util.Set;

public interface ParkingSystem {


    void reserveSpot(@Range(from = 1, to = Long.MAX_VALUE) long spotId, @NotNull ParkingClient client);

    void reserve(@NotNull Spot spot, @NotNull ParkingClient client);

    void releaseSpot(@Range(from = 1, to = Long.MAX_VALUE) long spotId);

    void releaseSpot(@NotNull Spot spot);

    @NotNull Set<@Range(from = 1, to = Long.MAX_VALUE) Integer> getAvailableSpots();

    @NotNull Set<@Range(from = 1, to = Long.MAX_VALUE) Integer> getBusySpots();

}
