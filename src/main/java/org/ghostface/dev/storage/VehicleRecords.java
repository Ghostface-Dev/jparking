package org.ghostface.dev.storage;

import org.ghostface.dev.imp.Vehicle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class VehicleRecords extends LocalStorage<@NotNull Vehicle> {

    public VehicleRecords(@NotNull String rootFolder) {
        super(rootFolder);
    }

    @Override
    public final @Nullable Vehicle getById(long vehicleId) {
        return entities.stream()
                .filter(vehicle -> vehicle.getId() == vehicleId)
                .findFirst()
                .orElse(null);
    }
}
