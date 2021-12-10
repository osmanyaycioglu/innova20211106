package com.training.spring.restaurant.rest.models;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class Menu {

    private String     menuName;
    private List<Meal> meals;
    @NotEmpty
    private String     extra;

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(final String menuNameParam) {
        this.menuName = menuNameParam;
    }

    public List<Meal> getMeals() {
        return this.meals;
    }

    public void setMeals(final List<Meal> mealsParam) {
        this.meals = mealsParam;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(final String extraParam) {
        this.extra = extraParam;
    }


}
