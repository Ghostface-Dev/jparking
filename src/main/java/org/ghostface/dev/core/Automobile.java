package org.ghostface.dev.core;

import org.ghostface.dev.impl.Client;
import org.jetbrains.annotations.NotNull;

import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

import org.ghostface.dev.core.Person.*;
import org.jetbrains.annotations.Range;

interface Automobile {

    @NotNull String getPlate();

    @NotNull String getBrand();

    @NotNull String getName();

    @NotNull String getColor();

    void setColor(@NotNull String color);


}
