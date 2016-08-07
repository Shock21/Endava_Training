package com.endava.jpa.service;

import com.endava.jpa.model.Department;

import java.util.List;

public interface DepartmentService extends JPAService<Department> {

	public Department find(int id);

	public List<Department> find(String departmentName);

}
