package com.training.spring;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.ms.common.error.ErrorConfig;
import com.ms.common.error.feign.FeignErrorDecoder;

@SpringBootApplication
@EnableFeignClients
//@SpringBootApplication(scanBasePackages = {
//                                            "com.training.spring",
//                                            "com.ms.common.error"
//})
@ServletComponentScan
@Import({
          ErrorConfig.class,
          FeignErrorDecoder.class
})
public class MsOrderApplication {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public static void main(final String[] args) {
        SpringApplication.run(MsOrderApplication.class,
                              args);
    }

}
