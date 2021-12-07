package com.training.spring.models;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Person {

    private String    name;
    private String    surname;
    //@JsonIgnore
    @XmlTransient
    private LocalDate birthday;
    private int       weight;
    private int       height;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(final LocalDate birthdayParam) {
        this.birthday = birthdayParam;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(final int weightParam) {
        this.weight = weightParam;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(final int heightParam) {
        this.height = heightParam;
    }

    @Override
    public String toString() {
        return "Person [name="
               + this.name
               + ", surname="
               + this.surname
               + ", birthday="
               + this.birthday
               + ", weight="
               + this.weight
               + ", height="
               + this.height
               + "]";
    }


}
