public class RentalSystem {
    public static void main(String[] args) {
        int rentalDays = 3;

        Vehicle myCar = new Car("Toyota Avanza", 300000);
        Vehicle myTruck = new Truck("Isuzu Elf", 800000, 150000);
        Vehicle myLuxuryCar = new LuxuryCar("Alphard", 1500000, 500000);

        Vehicle[] vehicles = {myCar, myTruck, myLuxuryCar};

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle: " + v.getModel());
            System.out.println("Total Cost: " + v.calculateRentalCost(rentalDays));
            System.out.println("-------------------------");
        }
    }
}