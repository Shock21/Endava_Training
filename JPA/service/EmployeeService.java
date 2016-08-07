package com.endava.jpa.service;

import com.endava.jpa.model.Employee;

import java.util.List;

public interface EmployeeService extends JPAService<Employee> {

    public Employee find(int id);

    public List<Employee> find(String employeeName);

    public List<Employee> getEmployeeByDeptAndCity(int id, String city);
}
