package org.katas.refactoring;

public class LineItem {
    private String name;
    private double price;
    private int quantity;

    public LineItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    double totalAmount() {
        return this.price * this.quantity;
    }
}