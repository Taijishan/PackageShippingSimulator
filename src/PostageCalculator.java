import java.text.DecimalFormat;
import java.math.RoundingMode;

public class PostageCalculator {
    private static double BASE_COST = 3.75;
    public static String calculatePostage(int originZip, int destZip, double weight, double length, double width, double height) {
        DecimalFormat df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.HALF_UP);

        double finalCost = BASE_COST;
        if (weight <= 40) {
            finalCost += (weight * 0.5); //weight is the amount of pounds, so this is base cost + 50c per pound
        } else {
            finalCost += (40 * 0.5) + (weight - 40);
        }
        String zip1 = String.valueOf(originZip);
        String zip2 = String.valueOf(destZip);
        int countyCode1 = Integer.parseInt(zip1.substring(0,3));
        int countyCode2 = Integer.parseInt(zip2.substring(0,3));
        finalCost += (double) (Math.abs(countyCode1 - countyCode2))/100;
        if (length+width+height > 36) {
            finalCost += ((length+width+height) - 36) * 0.1;
        }
        return df.format(finalCost);
    }

    public static String calculatePostage(String address1, String address2, double weight, double length, double width, double height) {
        DecimalFormat df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.HALF_UP);

        double finalCost = BASE_COST;
        Package p = new Package(new Address(address1), new Address(address2), lbs, length, width, height);
        if (weight <= 40) {
            finalCost += (lbs * 0.5);
        } else {
            finalCost += (40 * 0.5) + (weight - 40);
        }
        String zip1 = String.valueOf(p.getOrigin().getZipcode());
        String zip2 = String.valueOf(p.getDestination().getZipcode());
        int countyCode1 = Integer.parseInt(zip1.substring(0,3));
        int countyCode2 = Integer.parseInt(zip2.substring(0,3));
        finalCost += (double) (Math.abs(countyCode1 - countyCode2)) /100;
        if (length+width+height > 36) {
            finalCost += ((length+width+height) - 36) * 0.1;
        }
        return df.format(finalCost);
    }

    public static String calculatePostage(Package p) {
        DecimalFormat df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.HALF_UP);

        double finalCost = BASE_COST;
        if (p.getPounds() <= 40) {
            finalCost += (p.getPounds() * 0.5);
        } else {
            finalCost += (40 * 0.5) + (p.getPounds() - 40);
        }
        String zip1 = String.valueOf(p.getOrigin().getZipcode());
        String zip2 = String.valueOf(p.getDestination().getZipcode());
        int countyCode1 = Integer.parseInt(zip1.substring(0,3));
        int countyCode2 = Integer.parseInt(zip2.substring(0,3));
        finalCost += (double) (Math.abs(countyCode1 - countyCode2)) /100;
        if (p.getLength()+p.getWidth()+p.getHeight() > 36) {
            finalCost += ((p.getLength()+p.getWidth()+p.getHeight()) - 36) * 0.1;
        }
        return df.format(finalCost);
    }
}
