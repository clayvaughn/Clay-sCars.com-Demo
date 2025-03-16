/*
 *
 *
 */

package rentalsystem;

public class Rental {

    // attributes
    private Customer customer;
    private Car car;
    private int days;
    private double totalCost;

    // constructor with parameters
    public Rental(Customer customer, Car car, int days) {
        this.customer = customer;
        this.car = car;
        this.days = days;
        this.totalCost = calculateCost();
    }

    // calculate total rental cost
    private double calculateCost() {
        return car.getDailyRate() * days;
    }

    // get and return totalCost
    public double getTotalCost() {
        return totalCost;
    }

    // menu display
    public void displayRentalInfo() {
        System.out.println("\n=== Rental Information ===");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Car: " + car.getBrand() + " " + car.getModel());
        System.out.println("Days: " + days);
        System.out.println("Total Cost: $" + totalCost);
    }
}
