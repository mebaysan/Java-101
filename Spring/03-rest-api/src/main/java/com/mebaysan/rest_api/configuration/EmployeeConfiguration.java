package com.mebaysan.rest_api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mebaysan.rest_api.entity.Employee;
import com.mebaysan.rest_api.services.IEmployeeService;

@Configuration
public class EmployeeConfiguration {
    private IEmployeeService employeeService;

    @Autowired
    public EmployeeConfiguration(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            employeeService.save(new Employee("Enes", "Baysan", "mail@mebaysan.com"));
            employeeService.save(new Employee("Muhammed", "Baysan", "mail@mebaysan.com"));
        };
    }
}
