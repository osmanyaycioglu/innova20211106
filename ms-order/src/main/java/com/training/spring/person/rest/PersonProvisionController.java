package com.training.spring.person.rest;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.mappers.PersonMapper;
import com.training.spring.person.rest.models.PersonRestObj;
import com.training.spring.person.services.PersonProvisionService;

@RestController
@RequestMapping("/api/v1/person/provision")
@Validated
public class PersonProvisionController {

    @Autowired
    private PersonProvisionService pps;

    @PostMapping("/add")
    public String add(@Validated @RequestBody final PersonRestObj person) {
        if ("unknown".equals(person.getName())) {
            throw new IllegalArgumentException("Unknown olamaz");
        }
        this.pps.add(PersonMapper.toPerson(person));
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
