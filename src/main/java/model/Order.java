package model;

import java.time.LocalDate;
import java.util.Date;

public class Order {

    private int orderId;
    private String name;
    private String phoneNumber;
    private String detailAddress;
    private double total;
    private LocalDate orderDate;
    private Customer customer;
    private Address address;
    private Discount discount;

    public Order() {
    }

    public Order(int orderId, String name, String phoneNumber, String detailAddress, double total, LocalDate orderDate, Customer customer, Address address, Discount discount) {
        this.orderId = orderId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.detailAddress = detailAddress;
        this.total = total;
        this.orderDate = orderDate;
        this.customer = customer;
        this.address = address;
        this.discount = discount;
    }

    public Order(String name, String phoneNumber, String detailAddress, double total, LocalDate orderDate, Customer customer, Address address, Discount discount) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.detailAddress = detailAddress;
        this.total = total;
        this.orderDate = orderDate;
        this.customer = customer;
        this.address = address;
        this.discount = discount;
    }

    public Order(String name, String phoneNumber, String detailAddress, double total, LocalDate orderDate, Customer customer, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.detailAddress = detailAddress;
        this.total = total;
        this.orderDate = orderDate;
        this.customer = customer;
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", total=" + total +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", address=" + address +
                ", discount=" + discount +
                '}';
    }
}
