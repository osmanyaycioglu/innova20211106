package com.training.spring.order.integrations.restaurant;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ms.common.error.feign.MyFeignClientException;
import com.training.spring.order.integrations.models.Menu;
import com.training.spring.order.integrations.models.MenuPriceInfo;

@FeignClient("RESTAURANT-API")
//@RequestMapping("/api/v1/restaurant/menu")
public interface IRestaurantMenuIntegration {

    @PostMapping("/api/v1/restaurant/menu/calculate")
    public MenuPriceInfo calculate(@RequestBody final Menu menu) throws MyFeignClientException;

}
