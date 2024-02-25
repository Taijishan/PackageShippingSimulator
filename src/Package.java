public class Package {
    private Address origin;
    private Address destination;
    private double pounds;
    private double length;
    private double width;
    private double height;

    public Package(Address origin, Address destination, double pounds, double length, double width, double height) {
        this.origin = origin;
        this.destination = destination;
        this.pounds = pounds;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Address getOrigin() {
        return origin;
    }

    public Address getDestination() {
        return destination;
    }

    public double getPounds() {
        return pounds;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }
}