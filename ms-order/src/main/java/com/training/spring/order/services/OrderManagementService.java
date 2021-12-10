package com.training.spring.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.order.integrations.models.MenuPriceInfo;
import com.training.spring.order.integrations.restaurant.RestaurantMenuClient;
import com.training.spring.order.models.Order;

@Service
public class OrderManagementService {

    @Autowired
    private RestaurantMenuClient rmc;

    public String place(final Order order) {
        MenuPriceInfo menuPriceInfoLoc = this.rmc.calculateMenu(order);
        return "menu fiyatı : " + menuPriceInfoLoc.getPrice() + " port : " + menuPriceInfoLoc.getPort();

    }

}
