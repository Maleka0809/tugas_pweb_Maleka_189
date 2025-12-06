public class LuxuryCar extends Vehicle {
    private double luxuryFee;

    public LuxuryCar(String model, double baseRate, double luxuryFee) {
        super(model, baseRate);
        this.luxuryFee = luxuryFee;
    }

    @Override
    public double calculateRentalCost(int rentalDays) {
        return (baseRate * rentalDays) + luxuryFee;
    }
}