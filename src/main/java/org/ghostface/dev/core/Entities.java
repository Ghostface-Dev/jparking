package org.ghostface.dev.core;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.io.Serializable;
import java.util.Objects;

public abstract class Entities implements Serializable {

    private final @Range(from = 1, to = Long.MAX_VALUE) int id;

    public Entities(@Range(from = 1, to = Long.MAX_VALUE) int id) {
        this.id = id;
    }

    public final @Range(from = 1, to = Long.MAX_VALUE) int getId() {
        return id;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        @NotNull Entities entities = (Entities) object;
        return id == entities.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
