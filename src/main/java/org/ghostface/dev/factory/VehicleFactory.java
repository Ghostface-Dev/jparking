package org.ghostface.dev.factory;

import org.jetbrains.annotations.NotNull;

public interface VehicleFactory {

    @NotNull String getModel();

    @NotNull String getBrand();

    @NotNull String getPlate();

    @NotNull String getColor();

    void setColor(@NotNull String color);

}
