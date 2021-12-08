package com.training.spring.models;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.training.spring.validation.StartWith;

@XmlRootElement
public class Person {

    @NotEmpty
    @Size(min = 2, max = 20, message = "name {min} ile {max} arasında olmalı")
    @StartWith("n:")
    private String    name;
    @NotEmpty
    @Size(min = 2, max = 20)
    @StartWith("s:")
    private String    surname;
    //@JsonIgnore
    @XmlTransient
    @Past
    private LocalDate birthday;
    @Max(400)
    @Min(10)
    private int       weight;
    @Max(400)
    @Min(50)
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
