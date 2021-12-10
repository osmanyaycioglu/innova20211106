package com.training.spring.order.integrations.restaurant;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.common.error.feign.MyFeignClientException;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.spring.order.integrations.models.Menu;
import com.training.spring.order.integrations.models.MenuPriceInfo;
import com.training.spring.order.models.Order;

import io.github.resilience4j.circuitbreaker.CircuitBreaker.Metrics;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class RestaurantMenuClient {

    @Autowired
    private RestTemplate               rt;

    @Autowired
    private EurekaClient               eurekaClient;

    @Autowired
    private IRestaurantMenuIntegration menuIntegration;

    @Autowired
    private CircuitBreakerRegistry     cbr;

    @Autowired
    private RetryRegistry              registry;

    private int                        count = 0;

    @Retry(name = "restaurantretry", fallbackMethod = "calculateMenuFalback")
    @CircuitBreaker(name = "cbrestaurant")
    public MenuPriceInfo calculateMenu(final Order orderParam) throws MyFeignClientException {
        io.github.resilience4j.retry.Retry retryLoc = this.registry.retry("restaurantretry");
        io.github.resilience4j.retry.Retry.Metrics metrics2Loc = retryLoc.getMetrics();
        io.github.resilience4j.circuitbreaker.CircuitBreaker circuitBreakerLoc = this.cbr.circuitBreaker("cbrestaurant");
        Metrics metricsLoc = circuitBreakerLoc.getMetrics();
        this.count++;
        if ((this.count % 3) == 0) {
            throw new IllegalArgumentException("cb test");
        }
        System.out.println(this.count
                           + " "
                           + circuitBreakerLoc.getState()
                           + " ft : "
                           + metricsLoc.getFailureRate()
                           + " sc : "
                           + metricsLoc.getNumberOfSuccessfulCalls()
                           + " fc : "
                           + metricsLoc.getNumberOfFailedCalls()
                           + " np : "
                           + metricsLoc.getNumberOfNotPermittedCalls()
                           + " slow : "
                           + metricsLoc.getNumberOfSlowCalls());
        Menu menuLoc = new Menu();
        menuLoc.setMeals(orderParam.getMeals());
        menuLoc.setMenuName("Menu : " + orderParam.getName() + " " + orderParam.getSurname());
        menuLoc.setExtra("extra");
        MenuPriceInfo menuPriceInfoLoc = this.menuIntegration.calculate(menuLoc);
        return menuPriceInfoLoc;
    }

    public MenuPriceInfo calculateMenuFalback(final Order orderParam,
                                              final Throwable th) {
        MenuPriceInfo info = new MenuPriceInfo();
        info.setPort(0);
        info.setPrice(1000);
        return info;
    }

    public MenuPriceInfo calculateMenu3(final Order orderParam) {
        Menu menuLoc = new Menu();
        menuLoc.setMeals(orderParam.getMeals());
        menuLoc.setMenuName("Menu : " + orderParam.getName() + " " + orderParam.getSurname());
        MenuPriceInfo menuPriceInfoLoc = this.rt.postForObject("http://RESTAURANT-API/api/v1/restaurant/menu/calculate",
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
