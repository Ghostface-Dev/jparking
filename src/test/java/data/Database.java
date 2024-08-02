package data;

import com.google.gson.JsonElement;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class Database implements Iterable<JsonElement> {
    private final @NotNull Set<@NotNull JsonElement> elements = new HashSet<>();
    private final @NotNull File file;

    public Database(@NotNull String path) {
        this.file = new File(path, "DataBase.ser");
    }

    public void main(String[] args) {

    }

    public @NotNull Set<@NotNull JsonElement> getElements() {
        return elements;
    }

    public @NotNull File getFile() {
        return file;
    }

    @Override
    public @NotNull Iterator<@NotNull JsonElement> iterator() {
        return elements.iterator();
    }


}
