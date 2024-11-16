package com.mebaysan.rest_api.dao;

import java.util.List;

import com.mebaysan.rest_api.entity.Employee;

public interface IEmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee save(Employee employee);

    public void deleteById(int id);

}
