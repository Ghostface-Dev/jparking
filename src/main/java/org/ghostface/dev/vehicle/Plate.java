package org.ghostface.dev.vehicle;

import org.jetbrains.annotations.NotNull;

public class Plate {
    public final @NotNull String plate;
    private final @NotNull String PLATE_PATTERN = "^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$";

    /*
    * Plate Standard:
    * ABC1234 or ABC1D23
    * */

    public Plate(@NotNull String plate) {
        plate = plate.toUpperCase();
        if (!plate.matches(PLATE_PATTERN)) {
            throw new IllegalArgumentException("Invalid plate");
        }
        this.plate = plate;
    }

}
