package maktab74.domain;

public abstract class Product {

    private int id;

    private String name;

    private String madeIn;

    private int price;

    private int number;

    public Product() {

    }

    public Product(int id, String name, String madeIn, int price, int number) {
        this.id = id;
        this.name = name;
        this.madeIn = madeIn;
        this.price = price;
        this.number = number;
    }

    public Product(String name, String madeIn, int price, int number) {
        this.name = name;
        this.madeIn = madeIn;
        this.price = price;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", madeIn='" + madeIn + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}

