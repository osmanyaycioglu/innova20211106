package com.training.spring.person.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.models.Person;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQueryController {

    @GetMapping("/get/one/{pid}")
    public Person getOne(@PathVariable("pid") final Long personId) {
        return null;
    }

    @GetMapping("/get/all")
    public List<Person> getAll() {
        return null;
    }

    @GetMapping("/get/one/{surname}")
    public List<Person> getOne(@PathVariable("surname") final String surname) {
        return null;
    }


}
