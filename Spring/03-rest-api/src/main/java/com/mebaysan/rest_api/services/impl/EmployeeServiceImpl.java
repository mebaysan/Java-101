package com.mebaysan.rest_api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mebaysan.rest_api.dao.EmployeeRepository;
import com.mebaysan.rest_api.dao.IEmployeeDAO;
import com.mebaysan.rest_api.entity.Employee;
import com.mebaysan.rest_api.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    // private IEmployeeDAO employeeDAO;

    // @Autowired
    // public EmployeeServiceImpl(IEmployeeDAO employeeDAO) {
    // this.employeeDAO = employeeDAO;
    // }

    // @Override
    // public List<Employee> findAll() {
    // return employeeDAO.findAll();
    // }

    // @Override
    // public Employee findById(int id) {
    // return employeeDAO.findById(id);
    // }

    // @Override
    // @Transactional
    // public Employee save(Employee employee) {
    // return employeeDAO.save(employee);
    // }

    // @Override
    // @Transactional
    // public void deleteById(int id) {
    // employeeDAO.deleteById(id);
    // }
}
