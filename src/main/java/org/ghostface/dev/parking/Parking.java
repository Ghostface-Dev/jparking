package org.ghostface.dev.parking;


import org.ghostface.dev.core.ParkingClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.Set;

public interface Parking {

    void reserveSpot(@Range(from = 1, to = Long.MAX_VALUE) int spotId, @NotNull ParkingClient client);

    void releaseSpot(@Range(from = 1, to = Long.MAX_VALUE) int spotId);

    @NotNull Set<@NotNull Integer> spotsAvailable();

    @NotNull Set<@NotNull Integer> spotsOccupied();

    @Nullable Spot getSpot(@Range(from = 1, to = Long.MAX_VALUE) int spotId);

}
