package org.ghostface.dev;

import org.ghostface.dev.imp.Client;
import org.ghostface.dev.imp.Vehicle;
import org.ghostface.dev.storage.ClientRecords;
import org.ghostface.dev.storage.VehicleRecords;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle(11, "aws", "shaolin", "toyota", "red");
        Client client = new Client(12, "henrique", "555", "@", vehicle);

        ClientRecords cr = new ClientRecords("C:\\temp");
        VehicleRecords vr = new VehicleRecords("C:\\temp2");

        cr.register(client);
        vr.register(vehicle);

        System.out.println(vr.getById(11).getBrand());
        System.out.println(cr.getById(12).getVehicle());

    }
}
