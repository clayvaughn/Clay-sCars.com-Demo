/*
 *
 *
 */

package rentalsystem;

public class Car {

    // attributes
    private String id;
    private String brand;
    private String model;
    private double dailyRate;
    private boolean isAvailable;

    // constructor with parameters
    public Car(String id, String brand, String model, double dailyRate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getDailyRate() { return dailyRate; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public String toString() {
        return "Car ID: " + id + " - " + brand + " " + model + " ($" + dailyRate + " per day)";
    }
}
