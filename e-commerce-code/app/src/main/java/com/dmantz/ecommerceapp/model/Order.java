package com.dmantz.ecommerceapp.model;

import java.util.ArrayList;

public class Order {

    String itemName;
    String itemSize;
    double itemPrice;
    String itemImageUrl;
    int itemId;

    ArrayList orderObj;

    public ArrayList<Order> getOrderObj() {
        return orderObj;
    }

    public void setOrderObj(ArrayList<Order> orderObj) {


        this.orderObj = orderObj;
    }


    public Order() {

        orderObj = new ArrayList();

        orderObj.add(itemName);

}


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemImageUrl() {
        return itemImageUrl;
    }

    public void setItemImageUrl(String itemImageUrl) {
        this.itemImageUrl = itemImageUrl;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
