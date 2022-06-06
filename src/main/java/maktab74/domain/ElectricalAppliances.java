package maktab74.domain;

public abstract class ElectricalAppliances extends Product {

    private String brand;

    public ElectricalAppliances() {
    }


    public ElectricalAppliances(int id, String name, String madeIn, int price, int number, String brand) {
        super(id, name, madeIn, price, number);
        this.brand = brand;
    }

    public ElectricalAppliances(String name, String madeIn, int price, int number, String brand) {
        super(name, madeIn, price, number);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "ElectricalAppliances{" +
                "brand='" + brand + '\'' +
                "} " + super.toString();
    }
}
