package com.mebaysan.spring_context_di.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoControllerTests {

    @Autowired
    DemoController demoController;
    @Autowired
    DemoControllerQualifierImplemented demoControllerQualifierImplemented;

    @Test
    void testGetDemoController() {
        System.out.println(demoController.sayHello());
    }

    @Test
    void testGetDemoControllerQualifierImplemented() {
        System.out.println(demoControllerQualifierImplemented.sayHello());
    }

}
