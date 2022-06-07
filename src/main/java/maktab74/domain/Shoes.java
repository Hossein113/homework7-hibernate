package maktab74.domain;

import javax.persistence.Entity;


public abstract class Shoes extends Product {

    private int size;

    private String material;

    private String color;


    public Shoes(int id, String name, String madeIn, int price, int number, int size, String material, String color) {
        super(id, name, madeIn, price, number);
        this.size = size;
        this.material = material;
        this.color = color;
    }

    public Shoes(String name, String madeIn, int price, int number, int size, String material, String color) {
        super(name, madeIn, price, number);
        this.size = size;
        this.material = material;
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                ", size=" + size +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                "} " + super.toString();
    }
}

