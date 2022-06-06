package maktab74.domain;

public class Address {

    private int id;

    private String State;

    private String City;

    private String streets;

    private String PostalCode;

    public Address() {
    }

    public Address(int id, String state, String city, String streets, String postalCode) {
        this.id = id;
        State = state;
        City = city;
        this.streets = streets;
        PostalCode = postalCode;
    }

    public Address(String state, String city, String streets, String postalCode) {
        State = state;
        City = city;
        this.streets = streets;
        PostalCode = postalCode;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreets() {
        return streets;
    }

    public void setStreets(String streets) {
        this.streets = streets;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalژode(String postalCode) {
        PostalCode = postalCode;
    }
}
