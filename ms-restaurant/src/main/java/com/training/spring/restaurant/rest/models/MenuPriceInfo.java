package com.training.spring.restaurant.rest.models;


public class MenuPriceInfo {

    private int price;
    private int port;


    public int getPrice() {
        return this.price;
    }


    public void setPrice(final int priceParam) {
        this.price = priceParam;
    }


    public int getPort() {
        return port;
    }


    public void setPort(int portParam) {
        port = portParam;
    }

}
