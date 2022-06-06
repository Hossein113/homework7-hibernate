package maktab74.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = SportShoe.TABLE_NAME)
public class SportShoe extends Shoes {

    public static final String TABLE_NAME = "sport_shoes";
    public static final String STRA_TYPE = "stra_type";
    public static final String SPORT_TYPE = "sport_type";

    @Column(name = STRA_TYPE)
    private String StraType;

    @Column(name = SPORT_TYPE)
    private String sportType;


    public SportShoe(int id, String name, String madeIn, int price, int number, int size, String material, String color, String straType, String sportType) {
        super(id, name, madeIn, price, number, size, material, color);
        StraType = straType;
        this.sportType = sportType;
    }

    public SportShoe(String name, String madeIn, int price, int number, int size, String material, String color, String straType, String sportType) {
        super(name, madeIn, price, number, size, material, color);
        StraType = straType;
        this.sportType = sportType;
    }

    public String getStraType() {
        return StraType;
    }

    public void setStraType(String straType) {
        this.StraType = straType;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    @Override
    public String toString() {
        return "SportShoe{" +
                "StraType='" + StraType + '\'' +
                ", sportType='" + sportType + '\'' +
                "} " + super.toString();
    }
}
