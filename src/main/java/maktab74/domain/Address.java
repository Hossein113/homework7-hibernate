package maktab74.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = Address.TABLE_NAME)
public class Address {


    public static final String TABLE_NAME = "address_table";
    public static final String ID = "id";
    public static final String STATE = "state";
    public static final String CITY = "city";
    public static final String STREETS = "streets";
    public static final String POSTALCODE = "PostalCode";

    @Column(name =ID )
    @GeneratedValue
    private int id;

    @Column(name = STATE )
    private String State;


    @Column(name =CITY )
    private String City;


    @Column(name = STREETS)
    private String streets;


    @Column(name = POSTALCODE)
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
