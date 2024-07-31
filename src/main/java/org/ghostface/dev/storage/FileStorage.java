package org.ghostface.dev.storage;

import org.ghostface.dev.core.Entities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

public interface FileStorage<T> {

    @Nullable T getById(@Range(from = 1, to = Long.MAX_VALUE) int id);

    void save(@NotNull T obj);

    void delete(@NotNull T obj);

}
