package com.endava.jpa.dao;

import com.endava.jpa.model.Department;

import java.util.List;

public interface DepartmentDao extends Dao<Department> {

	public Department find(int id);

	public List<Department> find(String departmentName);

}
