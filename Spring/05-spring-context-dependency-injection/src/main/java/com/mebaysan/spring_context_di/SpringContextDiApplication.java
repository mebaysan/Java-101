package com.mebaysan.spring_context_di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mebaysan.spring_context_di.controllers.DemoController;

@SpringBootApplication
public class SpringContextDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringContextDiApplication.class, args);
		DemoController demoController = ctx.getBean(DemoController.class);
		System.out.println(String.format(
				"In main method of SpringContextDiApplication class we get DemoController from the application context and executed it: %s",
				demoController.sayHello()));

	}

}
