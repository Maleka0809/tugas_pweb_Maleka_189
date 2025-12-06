public class Car extends Vehicle {

    public Car(String model, double baseRate) {
        super(model, baseRate);
    }

    @Override
    public double calculateRentalCost(int rentalDays) {
        return baseRate * rentalDays;
    }
}
