package maktab74.domain;

public class Television extends ElectricalAppliances {


    private String color;
    private int inchSize;
    private String voltageIn;
    private int channalNumber;
    private int speakerNumber;
    private String weight;
    private String ImageType;

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
        ImageType = imageType;
    }

    public Television(String name, String madeIn, int price, int number, String brand, String color, int inchSize, String voltageIn, int channalNumber, int speakerNumber, String weight, String imageType) {
        super(name, madeIn, price, number, brand);
        this.color = color;
        this.inchSize = inchSize;
        this.voltageIn = voltageIn;
        this.channalNumber = channalNumber;
        this.speakerNumber = speakerNumber;
        this.weight = weight;
        ImageType = imageType;
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
        return ImageType;
    }

    public void setImageType(String imageType) {
        ImageType = imageType;
    }

    @Override
    public String toString() {
        return "Television{" +
                ", inchSize=" + inchSize +
                ", voltageIn='" + voltageIn + '\'' +
                ", weight='" + weight + '\'' +
                ", ImageType='" + ImageType + '\'' +
                "} " + super.toString();
    }
}
