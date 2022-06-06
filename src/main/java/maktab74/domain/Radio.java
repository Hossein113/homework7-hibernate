package maktab74.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = Radio.TABLE_NAME)
public class Radio extends ElectricalAppliances {

    public static final String TABLE_NAME = "radio_table";
    public static final String COLOR = "color";
    public static final String SIZE = "size";
    public static final String VOLTAGE = "magazine_table";
    public static final String CHANNEL_NUMBER = "channel_number";
    public static final String SPEAKER_NUMBER = "speaker_number";
    public static final String WEIGHT = "weight";

@Column(name = COLOR)
    private String color;

    @Column(name =SIZE)
    private String size;

    @Column(name =VOLTAGE)
    private String voltageIn;

    @Column(name = CHANNEL_NUMBER)
    private int channelNumber;

    @Column(name = SPEAKER_NUMBER)
    private int speakerNumber;

    @Column(name = WEIGHT)
    private String weight;


    public Radio() {

    }

    public Radio(int id, String name, String madeIn, int price, int number, String brand, String color, String size, String voltageIn, int channelNumber, int speakerNumber, String weight) {
        super(id, name, madeIn, price, number, brand);
        this.color = color;
        this.size = size;
        this.voltageIn = voltageIn;
        this.channelNumber = channelNumber;
        this.speakerNumber = speakerNumber;
        this.weight = weight;
    }

    public Radio(String name, String madeIn, int price, int number, String brand, String color, String size, String voltageIn, int channelNumber, int speakerNumber, String weight) {
        super(name, madeIn, price, number, brand);
        this.color = color;
        this.size = size;
        this.voltageIn = voltageIn;
        this.channelNumber = channelNumber;
        this.speakerNumber = speakerNumber;
        this.weight = weight;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getVoltageIn() {
        return voltageIn;
    }

    public void setVoltageIn(String voltageIn) {
        this.voltageIn = voltageIn;
    }

    public int getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(int channelNumber) {
        this.channelNumber = channelNumber;
    }

    public int getSpeakerNumber() {
        return speakerNumber;
    }

    public void setSpeakerNumber(int speakerNumber) {
        this.speakerNumber = speakerNumber;
    }

    @Override
    public String toString() {
        return "Radio{" +

                ", voltageIn='" + voltageIn + '\'' +
                ", channelNumber=" + channelNumber +
                ", weight='" + weight + '\'' +
                "} " + super.toString();
    }
}
