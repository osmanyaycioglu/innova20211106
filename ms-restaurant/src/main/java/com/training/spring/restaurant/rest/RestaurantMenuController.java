package com.training.spring.restaurant.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.restaurant.rest.models.Menu;
import com.training.spring.restaurant.rest.models.MenuPriceInfo;

@RestController
@RequestMapping("/api/v1/restaurant/menu")
public class RestaurantMenuController {

    @Value("${server.port}")
    private int port;

    @PostMapping("/calculate")
    public MenuPriceInfo calculate(@Validated @RequestBody final Menu menu) {
        MenuPriceInfo menuPriceInfoLoc = new MenuPriceInfo();
        menuPriceInfoLoc.setPrice(120);
        menuPriceInfoLoc.setPort(this.port);
        return menuPriceInfoLoc;
    }

}
