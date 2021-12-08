package com.training.spring.person.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.data.PersonDAO;
import com.training.spring.models.Person;

@Service
public class PersonQueryService {

    @Autowired
    private PersonDAO personDAO;

    public Person getPerson(final String number) {
        return this.personDAO.getPerson(number);
    }

    public List<Person> getAll() {
        return this.personDAO.getAll();
    }

}
