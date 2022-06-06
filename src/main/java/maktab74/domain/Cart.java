package maktab74.domain;

import java.util.Arrays;
import java.util.List;

public class Cart {

    private int id;

    private int userId;

    private User user;

    private int price;

    private Product[] products;

    private List<Product> productList;

    private String refrence;

    public Cart() {

    }

    public Cart(int userId, String refrence) {
        this.userId = userId;
        this.refrence = refrence;
    }

    public Cart(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", price=" + price +
                ", products=" + Arrays.toString(products) +
                ", productList=" + productList +
                '}';
    }
}
