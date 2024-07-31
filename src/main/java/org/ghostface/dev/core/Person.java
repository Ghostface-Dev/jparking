package org.ghostface.dev.core;

import org.ghostface.dev.impl.Client;
import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;

import org.ghostface.dev.core.Automobile.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

interface Person {

    @NotNull String getName();

    @NotNull String getEmail();

    @NotNull String getCpf();

    void setEmail(@NotNull String email);

}
