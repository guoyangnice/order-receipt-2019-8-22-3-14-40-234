package org.katas.refactoring;

import java.util.List;

public class Order {
    String consumerName;
    String address;
    List<LineItem> goodsList;

    public Order(String consumerName, String address, List<LineItem> goodsList) {
        this.consumerName = consumerName;
        this.address = address;
        this.goodsList = goodsList;
    }

    public String getCustomerName() {
        return this.consumerName;
    }

    public String getCustomerAddress() {
        return this.address;
    }

    public List<LineItem> getLineItems() {
        return this.goodsList;
    }
}
