public class Truck extends Vehicle {
    private double heavyDutyFee;

    public Truck(String model, double baseRate, double heavyDutyFee) {
        super(model, baseRate);
        this.heavyDutyFee = heavyDutyFee;
    }

    @Override
    public double calculateRentalCost(int rentalDays) {
        return (baseRate * rentalDays) + heavyDutyFee;
    }
}