package ru.job4j.ood.lsp.foods;

import java.util.Calendar;

public class Food {
    private String name;
    private Calendar expiryDate;
    private Calendar createDate;
    private double price;
    private int discount;

    public Food(String name, Calendar expiryDate, Calendar createDate, double price, int discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }
}
