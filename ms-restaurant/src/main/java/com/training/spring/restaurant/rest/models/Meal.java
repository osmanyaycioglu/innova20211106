package com.training.spring.restaurant.rest.models;

import javax.validation.constraints.Max;

import org.springframework.validation.annotation.Validated;

@Validated
public class Meal {

    private String name;
    @Max(10)
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
