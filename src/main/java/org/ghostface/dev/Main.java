package org.ghostface.dev;

import org.ghostface.dev.impl.Client;
import org.ghostface.dev.impl.parking.ParkingSystem;
import org.ghostface.dev.impl.Vehicle;

public class Main {
    public static void main(String[] args) {

        ParkingSystem system = new ParkingSystem(15);
        System.out.println(system.spotsAvailable());

        Vehicle vehicle = new Vehicle(2, "SWS", "corsa", "ford", "red");
        Client client = new Client(1, "Henrique", "555", "@gmail.com", vehicle);

        system.reserveSpot(4, client);

        System.out.println(system.spotsAvailable());

        system.releaseSpot(4);

        System.out.println(system.getSpot(4).getClient());

    }
}
