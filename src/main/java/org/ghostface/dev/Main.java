package org.ghostface.dev;


import org.ghostface.dev.impl.Vehicle;
import org.ghostface.dev.vehicle.Brand;
import org.ghostface.dev.vehicle.Plate;

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Vehicle("Az", new Brand("ford"), new Plate("FKC0735"), "red");

        System.out.println(v.getBrand());
        System.out.println(v.getModel());
        System.out.println(v.getColor());
        System.out.println(v.getPlate());
    }
}
