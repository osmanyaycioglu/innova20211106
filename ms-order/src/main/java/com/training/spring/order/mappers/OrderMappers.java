package com.training.spring.order.mappers;

import com.training.spring.order.models.Order;
import com.training.spring.order.rest.models.OrderRestObj;

public class OrderMappers {

    public static Order toOrder(final OrderRestObj orderParam) {
        Order orderLoc = new Order();
        orderLoc.setMeals(orderParam.getMeals());
        orderLoc.setName(orderParam.getName());
        orderLoc.setSurname(orderParam.getSurname());
        orderLoc.setNumber(orderParam.getNumber());
        return orderLoc;
    }

}
