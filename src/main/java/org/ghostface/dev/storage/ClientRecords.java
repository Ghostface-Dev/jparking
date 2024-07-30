package org.ghostface.dev.storage;

import org.ghostface.dev.impl.Client;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClientRecords extends LocalStorage<@NotNull Client> {

    public ClientRecords(@NotNull String rootFolder) {
        super(rootFolder);
    }

    @Override
    public final @Nullable Client getById(long clientId) {
        return entities.stream()
                .filter(client -> client.getId() == clientId)
                .findFirst()
                .orElse(null);
    }
}
