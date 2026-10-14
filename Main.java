
import java.util.*;

public class Main {

    // Vehicle class
    static class Vehicle {
        String no;
        String model;
        double rate;
        boolean rented;

        Vehicle(String no, String model, double rate) {
            this.no = no;
            this.model = model;
            this.rate = rate;
        }

        @Override
        public String toString() {
            return no + " | " + model + " | " + rate
                    + "/day | " + (rented ? "Rented" : "Available");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Creating vehicles
        List<Vehicle> vehicles = new ArrayList<>(
                Arrays.asList(
                        new Vehicle("TN01", "Car", 1500),
                        new Vehicle("TN02", "Bike", 500),
                        new Vehicle("TN03", "SUV", 2500)
                )
        );

        while (true) {

            System.out.println("\n1. View");
            System.out.println("2. Rent");
            System.out.println("3. Return");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            // View vehicles
            if (choice == 1) {

                vehicles.forEach(System.out::println);

            }

            // Rent vehicle
            else if (choice == 2) {

                System.out.print("Vehicle number: ");
                String number = scanner.next();

                vehicles.stream()
                        .filter(vehicle ->
                                vehicle.no.equalsIgnoreCase(number))
                        .findFirst()
                        .ifPresent(vehicle ->
                                vehicle.rented = true);

            }

            // Return vehicle
            else if (choice == 3) {

                System.out.print("Vehicle number: ");
                String number = scanner.next();

                vehicles.stream()
                        .filter(vehicle ->
                                vehicle.no.equalsIgnoreCase(number))
                        .findFirst()
                        .ifPresent(vehicle ->
                                vehicle.rented = false);

            }

            // Exit
            else if (choice == 4) {

                System.out.println("Thank you for using Vehicle Rental System!");
                break;

            }

            else {
                System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}

