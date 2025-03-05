import java.util.Scanner;

public class TripCostCalculator {
    public static double CalculateTripCost(double kilometers, double fuelPrice, double fuelConsumption) {
        double fuelNeeded = (kilometers / 100) * fuelConsumption;
        return fuelNeeded * fuelPrice;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the distance of the trip in kilometers: ");
        double kilometers = scanner.nextDouble();

        System.out.println("Enter the price of fuel per liter: ");
        double fuelPrice = scanner.nextDouble();

        double fuelConsumption = 5.0;


        double tripCost = CalculateTripCost(kilometers, fuelPrice, fuelConsumption);
        System.out.println("The cost of the trip is: " + tripCost);
    }

}
