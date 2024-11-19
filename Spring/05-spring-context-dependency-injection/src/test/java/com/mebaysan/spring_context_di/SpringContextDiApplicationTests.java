package com.mebaysan.spring_context_di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.mebaysan.spring_context_di.controllers.DemoController;

@SpringBootTest
class SpringContextDiApplicationTests {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	DemoController demoController;

	@Test
	void testGetDemoControllerFromContext() {
		DemoController demoController = applicationContext.getBean(DemoController.class);
		System.out.println(demoController.sayHello());
	}

	@Test
	void contextLoads() {
	}

}
