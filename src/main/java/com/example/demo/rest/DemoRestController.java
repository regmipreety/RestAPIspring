package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    // add code for the "/hello" endpoint
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Test";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("John", "Doe"));
        theStudents.add(new Student("Marie", "Van"));
        theStudents.add(new Student("Paul", "Van"));


        return theStudents;
    }
}
