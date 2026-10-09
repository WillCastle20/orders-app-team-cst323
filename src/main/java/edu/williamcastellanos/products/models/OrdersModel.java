package edu.williamcastellanos.products.models;

public class OrdersModel {

    private int id;
    private String orderNumber;
    private String productName;
    private double price;
    private int qty;

    public OrdersModel() {
    }

    public OrdersModel(int id, String orderNumber, String productName, double price, int qty) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.productName = productName;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}