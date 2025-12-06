public abstract class Vehicle {
    protected String model;
    protected double baseRate;

    public Vehicle(String model, double baseRate) {
        this.model = model;
        this.baseRate = baseRate;
    }

    public String getModel() {
        return model;
    }

    public abstract double calculateRentalCost(int rentalDays);
}