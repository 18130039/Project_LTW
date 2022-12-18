package edu.beans;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String img;
    private String price;
    private long priceLong;
    private int quantity;

    public Product() {
    }

    public Product(String id, String name, String img, String price, long priceLong, int quantity) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.priceLong = priceLong;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name +
                ", Price: " + price +
                ", Quantity: " + quantity + "\n";
    }

    public long getPriceLong() {
        return priceLong;
    }

    public void setPriceLong(long priceLong) {
        this.priceLong = priceLong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public int getQuantity() { return quantity;}

    public void setQuantity(int quantity) { this.quantity = quantity;}

    public void add() {
        this.quantity++;
    }
    public void addMore(int quantity) {
        this.quantity += quantity;
    }

    public void sub() {
        this.quantity--;
    }
}


