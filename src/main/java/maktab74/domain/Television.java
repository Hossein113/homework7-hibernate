package maktab74.domain;

import javax.lang.model.element.Name;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Television.TABLE_NAME)
public class Television extends ElectricalAppliances {

    public static final String TABLE_NAME = "television_table";
    public static final String COLOR = "color";
    public static final String INCH_SIZE = "inch_size";
    public static final String VOLTAGE_IN = "voltage_in";
    public static final String CHANNAL_NUMBER = "channal_number";
    public static final String  SPEAKER_NUMBER = "speaker_number";
    public static final String WEIGHT = "weight";
    public static final String IMAGE_TYPE = "image_type";

@Column(name =COLOR )
    private String color;

    @Column(name = INCH_SIZE)
    private int inchSize;

    @Column(name = VOLTAGE_IN)
    private String voltageIn;

    @Column(name = CHANNAL_NUMBER )
    private int channalNumber;

    @Column(name = SPEAKER_NUMBER )
    private int speakerNumber;

    @Column(name = WEIGHT)
    private String weight;

    @Column(name = IMAGE_TYPE )
    private String imageType;

    public Television() {
    }

    public Television(int id, String name, String madeIn, int price, int number, String brand, String color, int inchSize, String voltageIn, int channalNumber, int speakerNumber, String weight, String imageType) {
        super(id, name, madeIn, price, number, brand);
        this.color = color;
        this.inchSize = inchSize;
        this.voltageIn = voltageIn;
        this.channalNumber = channalNumber;
        this.speakerNumber = speakerNumber;
        this.weight = weight;
        imageType = imageType;
    }

    public Television(String name, String madeIn, int price, int number, String brand, String color, int inchSize, String voltageIn, int channalNumber, int speakerNumber, String weight, String imageType) {
        super(name, madeIn, price, number, brand);
        this.color = color;
        this.inchSize = inchSize;
        this.voltageIn = voltageIn;
        this.channalNumber = channalNumber;
        this.speakerNumber = speakerNumber;
        this.weight = weight;
        imageType = imageType;
    }

    public int getChannalNumber() {
        return channalNumber;
    }

    public void setChannalNumber(int channalNumber) {
        this.channalNumber = channalNumber;
    }

    public int getSpeakerNumber() {
        return speakerNumber;
    }

    public void setSpeakerNumber(int speakerNumber) {
        this.speakerNumber = speakerNumber;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVoltageIn() {
        return voltageIn;
    }

    public void setVoltageIn(String voltageIn) {
        this.voltageIn = voltageIn;
    }



    public int getInchSize() {
        return inchSize;
    }

    public void setInchSize(int inchSize) {
        this.inchSize = inchSize;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        imageType = imageType;
    }

    @Override
    public String toString() {
        return "Television{" +
                ", inchSize=" + inchSize +
                ", voltageIn='" + voltageIn + '\'' +
                ", weight='" + weight + '\'' +
                ", ImageType='" + imageType + '\'' +
                "} " + super.toString();
    }
}
