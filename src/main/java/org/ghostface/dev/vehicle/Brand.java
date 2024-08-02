package org.ghostface.dev.vehicle;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class Brand {

    private static final @NotNull Set<@NotNull String> brands;
    public final @NotNull String brand;

    // static initializer

    static {
        brands = new HashSet<>();
        String[] carBrands = {
                "Alfa Romeo", "Audi", "BMW", "Chevrolet", "Chrysler", "Citroën", "Dacia", "Daewoo",
                "Dodge", "Fiat", "Ford", "Honda", "Hyundai", "Infiniti", "Jaguar", "Jeep", "Kia",
                "Land Rover", "Lexus", "Mazda", "Mercedes-Benz", "MINI", "Mitsubishi", "Nissan",
                "Opel", "Peugeot", "Porsche", "Renault", "Rover", "Saab", "Seat", "Škoda", "Smart",
                "Subaru", "Suzuki", "Toyota", "Volkswagen", "Volvo", "Hummer", "Ferrari", "Lamborghini",
                "Maserati", "Tesla", "Bentley", "Rolls-Royce", "Aston Martin", "McLaren"
        };
        for (@NotNull String brand : carBrands) {
            brands.add(brand.toLowerCase());
        }
    }

    public static void addBrand(@NotNull String brand) {
        brands.add(brand.toLowerCase());
    }

    // object

    public Brand(@NotNull String brand) {
        if (!brands.contains(brand.toLowerCase())) {
            throw new IllegalArgumentException("Brand not exist");
        } else {
            this.brand = brand.toLowerCase();
        }
    }
}
