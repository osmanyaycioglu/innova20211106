package com.training.spring.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.spring.models.Person;

@RestController
@RequestMapping("/play")
public class MyRestPlayground {

    @GetMapping("/hello")
    public String hello(@RequestParam("isim") final String name,
                        @RequestParam("soy") final String surname) {
        return "Hello GET " + name + " " + surname;
    }

    @GetMapping("/hello2/{isim}/surname/{soy}")
    public String hello2(@PathVariable("isim") final String name,
                         @PathVariable("soy") final String surname) {
        return "Hello 2 GET " + name + " " + surname;
    }

    // Yapma
    @GetMapping("/hello3")
    public String hello3(@RequestHeader("isim") final String name,
                         @RequestHeader("soy") final String surname) {
        return "Hello 3 GET " + name + " " + surname;
    }

    @PostMapping(value = "/hello4",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public String hello4(@RequestBody final Person person) {
        return "Hello 4 " + person;
    }

    @PostMapping(value = "/hello5",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Person hello5(@RequestBody final Person person) {
        person.setName("ali");
        return person;
    }

    @PostMapping(value = "/hello6")
    public ResponseEntity<Person> hello6(@RequestBody final Person person) {
        person.setName("ali");
        //        List<String> asListLoc = Arrays.asList("osman",
        //                                               "ali");
        //        asListLoc.stream()
        //                 .sorted()
        //                 .filter(s -> s.length() > 3)
        //                 .forEach(System.out::println);
        System.out.println("c1");
        return ResponseEntity.status(254)
                             .header("X-text",
                                     "test edildi")
                             .header("Content-Type",
                                     "application/json")
                             .body(person);

    }


    //Yapma
    @PostMapping(value = "/hello7/{operasyon}")
    public ResponseEntity<?> hello7(@PathVariable("operasyon") final String op,
                                    final HttpServletRequest hsr) throws Exception {
        switch (op) {
            case "add":
                ObjectMapper om = new ObjectMapper();
                Person person = om.readValue(hsr.getInputStream(),
                                             Person.class);
                person.setName("ali");
                return ResponseEntity.status(205)
                                     .header("X-text",
                                             "test edildi")
                                     .body(person);
            case "delete":
                return ResponseEntity.status(205)
                                     .header("X-text",
                                             "test edildi")
                                     .body("Deleted");
            default:
                return ResponseEntity.status(205)
                                     .header("X-text",
                                             "ok")
                                     .body("Deleted");
        }
    }


}

