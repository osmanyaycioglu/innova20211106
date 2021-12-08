package com.training.spring.mappers;

import java.util.ArrayList;
import java.util.List;

import com.training.spring.models.Person;
import com.training.spring.person.rest.models.PersonRestObj;

public class PersonMapper {

    public static Person toPerson(final PersonRestObj personParam) {
        Person personLoc = new Person();
        personLoc.setName(personParam.getName());
        personLoc.setSurname(personParam.getSurname());
        personLoc.setBirthday(personParam.getBirthday());
        personLoc.setHeight(personParam.getHeight());
        personLoc.setWeight(personParam.getWeight());
        personLoc.setNumber(personParam.getNumber());
        return personLoc;
    }

    public static PersonRestObj toPersonRest(final Person personParam) {
        PersonRestObj personLoc = new PersonRestObj();
        personLoc.setName(personParam.getName());
        personLoc.setSurname(personParam.getSurname());
        personLoc.setBirthday(personParam.getBirthday());
        personLoc.setHeight(personParam.getHeight());
        personLoc.setWeight(personParam.getWeight());
        personLoc.setNumber(personParam.getNumber());
        return personLoc;
    }

    public static List<PersonRestObj> toListPersonRest(final List<Person> allParam) {
        List<PersonRestObj> listLoc = new ArrayList<>();
        for (Person personLoc : allParam) {
            listLoc.add(toPersonRest(personLoc));
        }
        return listLoc;
    }

}
