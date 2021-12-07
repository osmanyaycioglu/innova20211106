package com.training.spring.servlet.person.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.models.Person;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionController {

    @PostMapping("/add")
    public String add(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping("/deactivate/{pid}")
    public String deactivate(@PathVariable("pid") final Long personId) {
        return "OK";
    }

    @GetMapping("/activate/{pid}")
    public String activate(@PathVariable("pid") final Long personId) {
        return "OK";
    }

}
