import java.util.HashMap;
import java.util.Map;

class Vehicle {
    private String type;

    public Vehicle(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Car extends Vehicle {
    public Car() {
        super("Car");
    }
}

class Bike extends Vehicle {
    public Bike() {
        super("Bike");
    }
}

class Scooter extends Vehicle {
    public Scooter() {
        super("Scooter");
    }
}

class VehicleRentalService {
    private Map<String, Double> rentalRates;

    public VehicleRentalService() {
        rentalRates = new HashMap<>();
        rentalRates.put("Car", 50.0); // Rates per day
        rentalRates.put("Bike", 20.0);
        rentalRates.put("Scooter", 10.0);
    }

    public double rentVehicle(String vehicleType, int rentalDuration, boolean insuranceIncluded) {
        double totalCost = rentalRates.get(vehicleType) * rentalDuration;
        if (insuranceIncluded) {
            totalCost += rentalDuration * 10; // Additional insurance cost
        }
        return totalCost;
    }

    public double rentVehicle(String vehicleType, int rentalDuration) {
        return rentalRates.get(vehicleType) * rentalDuration;
    }

    public double rentVehicle(String vehicleType) {
        return rentalRates.get(vehicleType);
    }
}

public class Main {
    public static void main(String[] args) {
        VehicleRentalService rentalService = new VehicleRentalService();

        // Rent a car with insurance for 7 days
        double carTotalCost = rentalService.rentVehicle("Car", 7, true);
        System.out.println("Total cost for renting a car with insurance for 7 days: $" + carTotalCost);

        // Rent a bike for 3 days
        double bikeTotalCost = rentalService.rentVehicle("Bike", 3);
        System.out.println("Total cost for renting a bike for 3 days: $" + bikeTotalCost);

        // Rent a scooter
        double scooterCostPerDay = rentalService.rentVehicle("Scooter");
        System.out.println("Cost per day for renting a scooter: $" + scooterCostPerDay);
    }
}
