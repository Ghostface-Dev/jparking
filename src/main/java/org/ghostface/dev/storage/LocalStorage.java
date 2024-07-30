package org.ghostface.dev.storage;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class LocalStorage<T>  {

    protected final @NotNull File file;
    protected final @NotNull Set<@NotNull T> entities = new HashSet<>();

    public LocalStorage(@NotNull String rootFolder) {
        @NotNull File directory = new File(rootFolder);

        if (!directory.exists()) {
            throw new IllegalArgumentException("This specify folder does not exist: " + rootFolder);
        }

        if (!directory.isDirectory()){
            throw new IllegalArgumentException("Directory must be a empty folder");
        }

        this.file = new File(directory, "LocalStorageEntities.ser");

        if (file.exists() && entities.isEmpty()) {
            loadFile();
        } else {
            createFile();
        }
    }

    private void loadFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file)) ) {
            @NotNull Object obj = in.readObject();
            @NotNull Set<?> set;
            if (obj instanceof Set<?>) {
                set = (Set<?>) obj;
                for (@NotNull Object elements : set) {
                    entities.add((T) elements);
                }
            } else {
                throw new ClassCastException("Deserialize object is not a set");
            }
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            System.err.println("Error loding file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createFile() {
        try {
            if (file.createNewFile()) {
                System.out.println("File created on " + file.getAbsoluteFile());
            }
        } catch (IOException e) {
            System.err.println("Failed to create a file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public final void register(@NotNull T obj) {
        if (entities.contains(obj)) {
            return;
        }
        entities.add(obj);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(entities);
            System.out.println("registered " + getClass().getName());
        } catch (IOException e) {
            System.err.println("Failed to register: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public abstract @Nullable T getById(long id);
}
