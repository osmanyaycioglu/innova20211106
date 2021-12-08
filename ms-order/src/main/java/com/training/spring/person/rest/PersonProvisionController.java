package com.training.spring.person.rest;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.models.Person;

@RestController
@RequestMapping("/api/v1/person/provision")
@Validated
public class PersonProvisionController {

    @PostMapping("/add")
    public String add(@Validated @RequestBody final Person person) {
        if ("unknown".equals(person.getName())) {
            throw new IllegalArgumentException("Unknown olamaz");
        }
        return "OK";
    }

    @GetMapping("/deactivate/{pid}")
    public String deactivate(@NotNull @PathVariable("pid") final Long personId) {
        return "OK";
    }

    @GetMapping("/activate/{pid}")
    public String activate(@NotNull @PathVariable("pid") final Long personId) {
        return "OK";
    }

}
