package org.ghostface.dev.impl;

import org.ghostface.dev.core.Person.*;
import org.ghostface.dev.parking.Parking;
import org.ghostface.dev.parking.Spot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import java.util.stream.Collectors;

public class ParkingSystem implements Parking {

    private final @NotNull Map<@NotNull Integer, @NotNull ParkingSpot> spots = new HashMap<>();

    public ParkingSystem(@Range(from = 1, to = Long.MAX_VALUE) int spotId) {
        for (int i = 1; i <= spotId; i++) {
            spots.put(i, new ParkingSpot(i));
        }
    }

    @Override
    public void reserveSpot(@Range(from = 1, to = Long.MAX_VALUE) int spotId, @NotNull ParkingClient client) {
        if (checkers(spotId)) {
            spots.get(spotId).setStatus(Spot.Status.BUSY);
            spots.get(spotId).setClient(client);
            System.out.println("Spot '" + spots.get(spotId).getId() + "' reserved by: " + client.getName());
        }
    }

    @Override
    public void releaseSpot(@Range(from = 1, to = Long.MAX_VALUE) int spotId) {
        if (checkers(spotId)) {
            if (spots.get(spotId).isAvailable()) {
                System.err.println("Spot is already empty");
            } else {
                spots.get(spotId).setStatus(Spot.Status.AVAILABLE);
                spots.get(spotId).setClient(null);
            }
        }
    }

    @Override
    public @NotNull Set<@NotNull Integer> spotsAvailable() {
        return spots.entrySet().stream()
                .filter(spot -> spot.getValue().getStatus() == Spot.Status.AVAILABLE)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public @NotNull Set<@NotNull Integer> spotsOccuped() {
        return spots.entrySet().stream()
                .filter(spot -> spot.getValue().getStatus() == Spot.Status.BUSY)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public @Nullable Spot getSpot(@Range(from = 1, to = Long.MAX_VALUE) int spotId) {
        if (checkers(spotId)) {
            return spots.get(spotId);
        }
        return null;
    }

    private boolean checkers(@Range(from = 1, to = Long.MAX_VALUE) int spotId) {
        if (!spots.containsKey(spotId)) {
            System.err.println("Spot not found");
            return false;
        }
        return true;
    }

}
