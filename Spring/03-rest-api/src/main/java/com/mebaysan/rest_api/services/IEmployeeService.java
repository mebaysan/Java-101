package com.mebaysan.rest_api.services;

import java.util.List;

import com.mebaysan.rest_api.entity.Employee;

public interface IEmployeeService {
    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

    public void deleteById(int id);
}
