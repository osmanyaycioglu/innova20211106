package com.training.spring.order.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.common.error.feign.MyFeignClientException;
import com.training.spring.order.integrations.models.MenuPriceInfo;
import com.training.spring.order.integrations.restaurant.RestaurantMenuClient;
import com.training.spring.order.models.Message;
import com.training.spring.order.models.Order;

@Service
public class OrderManagementService {

    @Autowired
    private RestaurantMenuClient rmc;

    @Autowired
    private RabbitTemplate       rt;

    public String place(final Order order) throws MyFeignClientException {
        MenuPriceInfo menuPriceInfoLoc = this.rmc.calculateMenu(order);
        Message messageLoc = new Message();
        messageLoc.setDest(order.getNumber());
        messageLoc.setStr("Siparişiniz alındı " + menuPriceInfoLoc.getPrice() + "TL.");
        this.rt.convertAndSend("notification-t-exchange",
                               "msg.ankara.sms.test.xyz",
                               messageLoc);
        return "menu fiyatı : " + menuPriceInfoLoc.getPrice() + " port : " + menuPriceInfoLoc.getPort();

    }

}
