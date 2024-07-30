package org.ghostface.dev.storage;

import org.ghostface.dev.imp.Client;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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
