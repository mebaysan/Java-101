package com.mebaysan.spring_context_di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mebaysan.spring_context_di.services.GreetingService;

@Controller
public class DemoController {

    @Autowired
    private final GreetingService greetingService;

    /* Dependency injection with Spring */
    @Autowired
    public DemoController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
