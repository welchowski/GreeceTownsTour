package com.example.lab5;

public class Towns {
    String name;
    String description;
    int img;
    int priceforday;
    int pricetotal;
    private int count;

    public Towns(String name, String description, int img, int priceforday) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.priceforday = priceforday;
    }

    public int getPricetotal() {
        return pricetotal;
    }

    public void setPricetotal(int pricetotal) {
        this.pricetotal = pricetotal;
    }

    public int getPriceforday() {
        return priceforday;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }
}

