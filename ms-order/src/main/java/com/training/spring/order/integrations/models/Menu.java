package com.training.spring.order.integrations.models;

import java.util.List;

import com.training.spring.order.rest.models.Meal;

public class Menu {

    private String     menuName;
    private List<Meal> meals;

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


}
