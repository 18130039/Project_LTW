package edu.beans;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String img;
    private String price;
    private String priceSale;
    private long priceLong;
    private int quantity;

    public Product() {
    }

    public Product(String id, String name, String img, String price, String priceSale, long priceLong) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.priceSale = priceSale;
        this.priceLong = priceLong;
    }

    @Override
    public String toString() {
        return name +
                ", Price: " + price +
                ", Quantity: " + quantity;
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

    public String getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(String priceSale) {
        this.priceSale = priceSale;
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


