package org.ghostface.dev.impl.data;

import org.ghostface.dev.core.Person.*;
import org.ghostface.dev.impl.Client;
import org.ghostface.dev.storage.FileStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.io.*;

import java.util.HashSet;
import java.util.Set;

public class CustomerRecord implements FileStorage<Client> {

    private final @NotNull Set<@NotNull Client> clients;
    private final @NotNull File file;

    public CustomerRecord(@NotNull String emptyFolder) {
        @NotNull File directory = new File(emptyFolder);
        if (!directory.exists()) {
            throw new IllegalArgumentException("Folder doe not exist");
        } else if (!directory.isDirectory() || directory.isFile()) {
            throw new IllegalArgumentException("Path must to be a empty folder");
        } else {
            this.clients = new HashSet<>();
            this.file = new File(directory, "ClientLocalStorage.ser");
            if (file.exists()) {
                load();
            } else {
                create();
            }
        }
    }

    private void create() {
        try {
            if (file.createNewFile()) {
                System.err.println("File create: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Failed to create file: "+ e.getMessage());
            e.printStackTrace();
        }
    }

    private void load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            @NotNull Object obj = in.readObject();
            if (obj instanceof Set<?>) {
                Set<?> set = (Set<?>) obj;
                clients.clear();
                for (@NotNull Object elements : set) {
                    if (elements instanceof Client) {
                        clients.add((Client) elements);
                    } else {
                        throw new ClassCastException("Element in the set is not of type Client");
                    }
                }
            } else {
                throw new ClassCastException("Deserialized object is not a set");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error to loading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public @Nullable Client getById(@Range(from = 1, to = Long.MAX_VALUE) int id) {
        for (@NotNull Client client: clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    @Override
    public void save(@NotNull Client obj) {
        if (clients.contains(obj)) {
            return;
        }
        if (clients.add(obj)) {
            writeToFile();
        }
    }

    @Override
    public void delete(@NotNull Client obj) {
        if (clients.remove(obj)) {
            writeToFile();
        }
    }

    private void writeToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(clients);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
