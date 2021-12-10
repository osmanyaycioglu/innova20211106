package com.training.spring.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@RefreshScope
public class MyRest {

    @Value("${prop.test1}")
    private String testStr;

    @GetMapping("test")
    public String test() {
        return this.testStr;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam("isim") final String name) {
        return "Hello GET " + name;
    }

    @PostMapping("/hello")
    public String helloPost(@RequestParam("isim") final String name) {
        return "Hello POST " + name;
    }

    @PutMapping("/hello")
    public String helloPut(@RequestParam("isim") final String name) {
        return "Hello Put " + name;
    }

    @PatchMapping("/hello")
    public String helloPatch(@RequestParam("isim") final String name) {
        return "Hello Patch " + name;
    }

    @DeleteMapping("/hello")
    public String helloDelete(@RequestParam("isim") final String name) {
        return "Hello Delete " + name;
    }

}
