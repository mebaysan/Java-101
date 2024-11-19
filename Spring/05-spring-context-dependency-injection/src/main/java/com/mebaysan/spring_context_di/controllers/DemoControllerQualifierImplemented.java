package com.mebaysan.spring_context_di.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.mebaysan.spring_context_di.services.GreetingService;

@Controller
public class DemoControllerQualifierImplemented {
    private final GreetingService greetingService;

    public DemoControllerQualifierImplemented(@Qualifier("greetingServiceImpl") GreetingService greetingService) { // set specific implementation
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }

}
