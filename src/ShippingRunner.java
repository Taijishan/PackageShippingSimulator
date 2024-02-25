import java.util.Scanner;

public class ShippingRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = "";
        while (!input.equals("4")) {
            System.out.println("---------------------------\nWhat would you like to do?\n");
            System.out.println("1. Calculate cost of a package\n2. Simulate packages\n3. How package costs are calculated\n4. Exit");
            System.out.print("Input: ");
            input = s.nextLine();
            if (input.equals("1")) {
                System.out.print("\nEnter the zip code of the origin: ");
                int originZip = Integer.parseInt(s.nextLine());
                if (originZip > 99950){
                    System.out.println("invalid zip code!");
                    System.out.print("\nEnter the zip code of the origin: ");
                    originZip = Integer.parseInt(s.nextLine());
                }
                System.out.print("Enter the zip code of the destination: ");
                int destZip = Integer.parseInt(s.nextLine());
                if (destZip > 99950){
                    System.out.println("invalid zip code!");
                    System.out.print("\nEnter the zip code of the origin: ");
                    destZip = Integer.parseInt(s.nextLine());
                }
                System.out.print("Enter the weight of the package(pounds): ");
                double weight = Double.parseDouble(s.nextLine());
                if (weight < 0.1){
                    System.out.println("invalid weight!");
                    System.out.print("Enter the weight of the package(pounds): ");
                    weight = Double.parseDouble(s.nextLine());
                }
                System.out.print("Enter the length of the package(inches): ");
                double length = Double.parseDouble(s.nextLine());
                if (length < 2){
                    System.out.println("invalid length!");
                    System.out.print("Enter the length of the package(inches): ");
                    length = Double.parseDouble(s.nextLine());
                }
                System.out.print("Enter the width of the package(inches): ");
                double width = Double.parseDouble(s.nextLine());
                if (width < 2){
                    System.out.println("invalid width!");
                    System.out.print("Enter the width of the package(inches): ");
                    width = Double.parseDouble(s.nextLine());
                }
                System.out.print("Enter the height of the package(inches): ");
                double height = Double.parseDouble(s.nextLine());
                if (height < 2){
                    System.out.println("invalid height!");
                    System.out.print("Enter the height of the package(inches): ");
                    height = Double.parseDouble(s.nextLine());
                }
                System.out.println("Cost: " + PostageCalculator.calculatePostage(originZip, destZip, weight, length, width, height));
            }
            else if (input.equals("2")) {
                System.out.print("\nHow many packages would you like to simulate: ");
                int amountToSimulate = Integer.parseInt(s.nextLine());
                PackageSimulator simulator = new PackageSimulator();
                simulator.generatePackages(amountToSimulate);
                System.out.println(simulator.getSimulationInfo());
            }
            else if (input.equals("3")) {
                System.out.println("\nPackages are calculated in 3 different ways:");
                System.out.println("1. Distance between origin and destination\n2. Size of package\n3. Weight of package");
                System.out.println("The base cost for a delivery is $3.75.");
                System.out.println("The price for distance comes from the difference in county codes(The first 3 numbers in the zip code) divided by 100.");
                System.out.println("The package gets charged extra if its dimensions combined exceeds 36 inches. It will be charged 10 cents for each inch above 36.");
                System.out.println("The package gets charged 50 cents for each pound up to 40 pounds. Packages will be charged 1 dollar for each pound over 40.\n");
            } else if (!input.equals("4")) {
                System.out.println("Please choose an available option.\n");
            }
        }
    }
}