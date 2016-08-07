package com.endava.jpa.dao;

import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;

import java.util.List;

public interface EmployeeDao extends Dao<Employee> {

    public Employee find(int id);

    public List<Employee> find(String employeeName);

    public List<Employee> getEmployeeByDeptAndCity(int id, String city);

}
