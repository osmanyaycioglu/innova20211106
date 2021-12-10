package com.training.spring.order.rest.models;


public class Meal {

    private String name;
    private int    count;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(final int countParam) {
        this.count = countParam;
    }


}
