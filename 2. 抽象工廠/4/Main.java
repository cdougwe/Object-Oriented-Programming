interface Vehicle {
    void drive();
}

class SUV implements Vehicle {
    public void drive() {
        System.out.println("Driving an SUV");
    }
}

class Sedan implements Vehicle {
    public void drive() {
        System.out.println("Driving a Sedan");
    }
}

interface VehicleFactory {
    Vehicle createVehicle();
}

class SedanFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Sedan();
    }
}

class SUVFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new SUV();
    }
}

class VehicleClient {
    Vehicle vehicle;

    public VehicleClient(VehicleFactory vehicleFactory) {
        this.vehicle = vehicleFactory.createVehicle();
    }

    public void driveVehicle() {
        vehicle.drive();
    }
}

public class Main {
    public static void main(String[] args) {
        VehicleClient os = new VehicleClient(new SedanFactory());
        os.driveVehicle();
        os = new VehicleClient(new SUVFactory());
        os.driveVehicle();
    }
}