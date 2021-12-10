package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.ms.common.error.ErrorConfig;

@SpringBootApplication
@Import({
          ErrorConfig.class,
})
public class MsRestaurantApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsRestaurantApplication.class,
                              args);
    }

}
