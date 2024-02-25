public class Address {
    private String houseNum;
    private String streetName;
    private String aptNum;
    private String city;
    private String state;
    private int zipcode;

    public Address(String houseNum, String streetName, String aptNum, String city, String state, int zipcode) {
        this.houseNum = houseNum;
        this.streetName = streetName;
        this.aptNum = aptNum;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    public Address(Address toCopy) {
        houseNum = toCopy.getHouseNum();
        streetName = toCopy.getStreetName();
        aptNum = toCopy.getAptNum();
        city = toCopy.getCity();
        state = toCopy.getState();
        zipcode = toCopy.getZipcode();
    }

    public Address(String location) {
        String[] addressParts = location.split(" ");
        houseNum = addressParts[0];
        streetName = addressParts[1] + " " + addressParts[2];
        aptNum = addressParts[3] + " " + addressParts[4].replaceAll(",", "");
        city = addressParts[5].replaceAll(",", "");
        state = addressParts[6];
        zipcode = Integer.parseInt(addressParts[7]);
    }

    public static Address randomAddress(){
        return new Address("123 Random Street Apt 3C, City, State " + ((int) (Math.random() * 99951) + 10000));
    }
    public String getHouseNum() {
        return houseNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAptNum() {
        return aptNum;
    }

    public String getCity() {
        return city;
    }


    public String getState() {
        return state;
    }

    public int getZipcode() {
        return zipcode;
    }
    public String toString() {
        return houseNum + " " + streetName + " " + aptNum + ", " + city + ", " + state + " " + String.format("%05d" , zipcode);
    }
}