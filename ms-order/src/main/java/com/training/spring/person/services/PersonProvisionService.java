package com.training.spring.person.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.data.PersonDAO;
import com.training.spring.models.Person;

@Service
public class PersonProvisionService {

    @Autowired
    private PersonDAO personDAO;

    public String add(final Person personParam) {
        this.personDAO.add(personParam);
        return "OK";
    }

}
