package org.ghostface.dev.impl;

import org.ghostface.dev.factory.ParkingClient;
import org.ghostface.dev.parking.ParkingSystem;
import org.ghostface.dev.parking.Spot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public final class ParkingSystemImpl implements ParkingSystem {

    private final @NotNull Map<@Range(from = 1, to = Long.MAX_VALUE) Long, @NotNull SpotImpl> spots;

    public ParkingSystemImpl(@Range(from = 1, to = Long.MAX_VALUE) int spotsSize) {
        this.spots = new HashMap<>();
        for (long i = 1; i < spotsSize; i++) {
            spots.put(i, new SpotImpl(i));
        }
    }

    public @NotNull Optional<@NotNull Client> getClient(@Range(from = 1, to = Long.MAX_VALUE) long spotId) {
        if (spots.containsKey(spotId)) {
            return Optional.ofNullable(spots.get(spotId).getClient());
        }
        return Optional.empty();
    }

    @Override
    public void reserveSpot(@Range(from = 1, to = Long.MAX_VALUE) long spotId, @NotNull ParkingClient client) {
        if (!spots.containsKey(spotId)) {
            System.err.println("Id invalid");
        } else if (spots.get(spotId).getStatus() == Spot.Status.BUSY) {
            System.err.println("Spot is already busy");
        } else {
            spots.get(spotId).setStatus(Spot.Status.BUSY);
        }
    }

    @Override
    public void reserve(@NotNull Spot spot, @NotNull ParkingClient client) {

    }

    @Override
    public void releaseSpot(@Range(from = 1, to = Long.MAX_VALUE) long spotId) {

    }

    @Override
    public void releaseSpot(@NotNull Spot spot) {

    }

    @Override
    public @NotNull Set<@Range(from = 1, to = Long.MAX_VALUE) Integer> getAvailableSpots() {
        return Set.of();
    }

    @Override
    public @NotNull Set<@Range(from = 1, to = Long.MAX_VALUE) Integer> getBusySpots() {
        return Set.of();
    }

}
