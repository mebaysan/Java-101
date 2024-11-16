package com.mebaysan.rest_api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mebaysan.rest_api.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
