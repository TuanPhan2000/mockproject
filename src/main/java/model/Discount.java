package model;

import java.time.LocalDate;
import java.util.Date;

public class Discount {

    private int discountId;
    private String title;
    private int type;
    private double discount;
    private LocalDate startDate;
    private LocalDate endDate;

    public Discount() {
    }

    public Discount(int discountId, String title, int type, double discount, LocalDate startDate, LocalDate endDate) {
        this.discountId = discountId;
        this.title = title;
        this.type = type;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Discount(String title, int type, double discount, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.type = type;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountId=" + discountId +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", discount='" + discount + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
