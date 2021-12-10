package com.training.spring.order.integrations.restaurant;

import java.util.function.Predicate;

import com.training.spring.order.integrations.models.MenuPriceInfo;

public class RestaurantMenuResultPredicate implements Predicate<MenuPriceInfo> {

    @Override
    public boolean test(final MenuPriceInfo tParam) {
        if (tParam.getPort() == 10_001) {
            return true;
        }
        return false;
    }

}
