package com.training.spring.order.integrations.restaurant;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.spring.order.integrations.models.Menu;
import com.training.spring.order.integrations.models.MenuPriceInfo;
import com.training.spring.order.models.Order;

@Service
public class RestaurantMenuClient {

    @Autowired
    private RestTemplate rt;

    @Autowired
    private EurekaClient eurekaClient;

    public MenuPriceInfo calculateMenu(final Order orderParam) {
        Menu menuLoc = new Menu();
        menuLoc.setMeals(orderParam.getMeals());
        menuLoc.setMenuName("Menu : " + orderParam.getName() + " " + orderParam.getSurname());
        MenuPriceInfo menuPriceInfoLoc = this.rt.postForObject("http://RESTAURANT/api/v1/restaurant/menu/calculate",
                                                               menuLoc,
                                                               MenuPriceInfo.class);
        return menuPriceInfoLoc;
    }

    public void calculateMenu2(final Order orderParam) {
        Menu menuLoc = new Menu();
        menuLoc.setMeals(orderParam.getMeals());
        menuLoc.setMenuName("Menu : " + orderParam.getName() + " " + orderParam.getSurname());
        Application applicationLoc = this.eurekaClient.getApplication("RESTAURANT");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        RestTemplate restTemplateLoc = new RestTemplate();
        MenuPriceInfo postForObjectLoc = restTemplateLoc.postForObject("http://"
                                                                       + instancesLoc.get(0)
                                                                                     .getIPAddr()
                                                                       + ":"
                                                                       + instancesLoc.get(0)
                                                                                     .getPort()
                                                                       + "/api/v1/restaurant/menu/calculate",
                                                                       menuLoc,
                                                                       MenuPriceInfo.class);
    }

}
