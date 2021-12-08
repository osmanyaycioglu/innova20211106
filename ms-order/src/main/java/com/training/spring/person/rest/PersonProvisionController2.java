package com.training.spring.person.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.models.Person;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionController2 {

    @PostMapping
    public String add(final Person person) {
        return "OK";
    }

    @DeleteMapping
    public String deactivate(@PathVariable("pid") final Long personId) {
        return "OK";
    }

    @PutMapping
    public String activate(@PathVariable("pid") final Long personId) {
        return "OK";
    }

    @PostMapping("/test")
    public String test(final Person person) {
        return "OK";
    }

}
