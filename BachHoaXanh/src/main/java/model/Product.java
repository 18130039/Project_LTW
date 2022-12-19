package model;

import java.io.Serializable;

public class Product implements Serializable {
	private String id;
	private String name;
	private String img;
	private int price;
	private int priceLong;
	private int quantity;
	private String categoryId;

	public Product() {
	}

	public Product(String id, String name, String img, int price, int priceLong, int quantity, String categoryId) {
		this.id = id;
		this.name = name;
		this.img = img;
		this.price = price;
		this.priceLong = priceLong;
		this.quantity = quantity;
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return name + ", Price: " + price + ", Quantity: " + quantity;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPriceLong() {
		return priceLong;
	}

	public void setPriceLong(int priceLong) {
		this.priceLong = priceLong;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

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
