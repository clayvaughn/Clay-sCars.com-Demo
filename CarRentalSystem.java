/*
 *
 * INFO-C 211 Final Project
 * Clay'sCars.com Demo
 *
 * File: CarRentalSystem.java
 *
 *
 * Test class for rental system
 * Create ArrayList for cars, customers, and rentals
 * Initialize cars for rental system
 * Generate user interface
 * Display appropriate output
 *
 *
 * @author: G 1
 * Clay Vaughn,
 * @version 1.0
 * @date: 3/15/25
 *
 */

package rentalsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class CarRentalSystem {

    // declare ArrayList and Scanner
    private ArrayList<Car> cars;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals;
    private Scanner scanner;

    public CarRentalSystem() {

        // assign ArrayList and Scanner
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeCars(); // Add some sample cars
    }

    // create car objects
    private void initializeCars() {

        // Car objects for rent
        cars.add(new Car("C001 Chandler Chevrolet", "Toyota", "Camry", 60.0));
        cars.add(new Car("C002 Clifty Motors", "Honda", "Accord", 65.0));
        cars.add(new Car("C003 Jeff Wyler", "BMW", "3 Series", 90.0));
        cars.add(new Car("C004 McCubbin Motors", "Tesla", "Model 3", 100.0));
    }

    public void showMainMenu() {
        while (true) {

            // user interface menu
            System.out.println("\n=== Car Rental System ===");
            System.out.println("1. Add Customer");
            System.out.println("2. View Available Cars");
            System.out.println("3. Rent a Car");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // case switch
            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    viewAvailableCars();
                    break;
                case 3:
                    rentCar();
                    break;
                case 4:
                    System.out.println("Thank you for using Car Rental System!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // case 1: add customer method
    private void addCustomer() {
        System.out.println("\n=== Add Customer ===");
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        customers.add(new Customer(id, name, phone, email));
        System.out.println("Customer added successfully!");
    }

    // case 2: view available cars method
    private void viewAvailableCars() {
        System.out.println("\n=== Available Cars ===");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
    }

    // case 3: rent car method
    private void rentCar() {
        if (customers.isEmpty()) {
            System.out.println("Please add a customer first!");
            return;
        }

        System.out.println("\n=== Rent a Car ===");
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        Customer customer = null;
        for (Customer c : customers) {
            if (c.getId().equals(customerId)) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        viewAvailableCars();
        System.out.print("Enter car ID to rent: ");
        String carId = scanner.nextLine();

        Car selectedCar = null;
        for (Car car : cars) {
            if (car.getId().equals(carId) && car.isAvailable()) {
                selectedCar = car;
                break;
            }
        }

        // if carID not found
        if (selectedCar == null) {
            System.out.println("Invalid car selection!");
            return;
        }

        System.out.print("Enter number of days for rental: ");
        int days = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Rental rental = new Rental(customer, selectedCar, days);
        rentals.add(rental);
        selectedCar.setAvailable(false);

        rental.displayRentalInfo();
    }

    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        rentalSystem.showMainMenu();
    }
}
