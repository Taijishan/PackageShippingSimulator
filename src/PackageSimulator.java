import java.util.ArrayList;
import java.text.DecimalFormat;
import java.math.RoundingMode;
public class PackageSimulator {
    ArrayList<Package> packages = new ArrayList<Package>();

    public void generatePackages(int amount) {
        for (int i = 0; i < amount; i++) {
            packages.add(new Package(Address.randomAddress(), Address.randomAddress(), (int) (Math.random() * 51.1) + 0.1,  (Math.random() * 19) + 2,  (Math.random() * 19) + 2,  (Math.random() * 19) + 2));
        }
    }

    public String generateTotalCost() {
        DecimalFormat df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        double totalCost = 0;
        for (Package p : packages) {
            totalCost += Double.parseDouble(PostageCalculator.calculatePostage(p));
        }
        return "The total cost for all these packages is: $" + df.format(totalCost);
    }

    public String getSimulationInfo() {
        String s = "Randomly generated packages info:\n";
        int packageNum = 0;
        for (Package p : packages) {
            packageNum++;
            s += "\nPackage " + packageNum + ": ___________________________________________\nOrigin address: " + p.getOrigin() + "\nDestination address: " + p.getDestination() + "\nWeight: " + p.getPounds() + " pounds\nLength: " + p.getLength() + " inches\nWidth: " + p.getWidth() +" inches\nHeight: " +p.getHeight() + " inches\nCost: $" + PostageCalculator.calculatePostage(p) + "\n";
        }
        return s + generateTotalCost();
    }

    public void resetSimulation(){
        packages.clear();
    }
}
