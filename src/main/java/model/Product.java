package model;

import java.time.LocalDate;

public class Product {

    private int productId;
    private String name;
    private String description;
    private double price;
    private double discountPrice;
    private int stock;
    private int sold;
    private LocalDate createDate;
    private int status;

    public Product() {
    }

    public Product(int productId, String name, String description, double price, double discountPrice, int stock, int sold, LocalDate createDate, int status) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountPrice = discountPrice;
        this.stock = stock;
        this.sold = sold;
        this.createDate = createDate;
        this.status = status;
    }


    public Product(String name, String description, double price, double discountPrice, int stock, LocalDate createDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountPrice = discountPrice;
        this.stock = stock;
        this.createDate = createDate;
    }

    public Product(int productId, String name, String description, double price, double discountPrice, int stock) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountPrice = discountPrice;
        this.stock = stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discountPrice=" + discountPrice +
                ", stock=" + stock +
                ", sold=" + sold +
                ", createDate=" + createDate +
                ", status=" + status +
                '}';
    }

}
