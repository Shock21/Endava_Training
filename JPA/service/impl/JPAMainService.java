package com.endava.jpa.service.impl;

import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;
import com.endava.jpa.service.DepartmentService;
import com.endava.jpa.service.EmployeeService;
import com.endava.jpa.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class JPAMainService {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProjectService projectService;

	//-------------------------------------- Department -----------------------------/

	public void findDepartment() {
		Department department = departmentService.find(1);
		System.out.println(department);
	}

	public void findDepartmentByName() {
		List<Department> departments = departmentService.find("Development");
		for(Department department : departments) {
			System.out.println(department);
		}
	}
	/**
	 *   Define a new department entity and insert it into the corresponding table
	 */
	 public void insertDepartment() {
		 Department dept = new Department();
		 dept.setName("Management");
		 dept.setId(3);
		 departmentService.save(dept);
	 }

	 /**
	 * Search for an existing department, update its name and save it using the new name
	 */
	public void updateDepartment() {
        Department updateDepartment = new Department();
        updateDepartment.setName("Development-Testing");
        departmentService.update(updateDepartment);
    }

	/**
	 * Delete an existing department from the database
	 */
	public void deleteDepartment() {
		Department department = departmentService.find(3);
		if(department != null) {
			departmentService.remove(department);
		}
	}

	//-------------------------------------- Employee -----------------------------/
	/**
	 * Create a new employee entity and save it into the corresponding table
	 */
	public void insertEmployee() {
		Department department = departmentService.find(3);

		Employee employee = new Employee();
		employee.setName("bernard");
		employee.setBirthday(new Date(19800405));
		employee.setCity("Bucharest");
		employee.setSalary((long)9200);
		employee.setState("Romania");
		employee.setStreet("Marasesti");
		employee.setZip_code("041726");
		employee.setDepartment(department);

		employeeService.save(employee);

	}

	/**
	 * Print to stdout all the employees from 'Bucharest', which belong to the department with id = 1.
	 * Make sure that there are more than two employees in Bucharest which belong to the department with id=1 when populating the DB.
	 * ! Use a join query.
	 */
	public void getEmployeesFromBucharest(){
		int dept_id = 1;
		String city = "Bucuresti";
		List<Employee> employees = employeeService.getEmployeeByDeptAndCity(dept_id, city);
		for(Employee e : employees) {
			System.out.println(e);
		}
	}

	/**
	 * Give a salary raise(+10%) for all employees that work in the 'Endava' project (project name = 'Endava').
	 * ! Use a join query.
	 */
	public void giveSalaryRaise(){}


	//-------------------------------------- Project -----------------------------/

	/**
	 * Add a new employee to the 'Endava' project. (project name = 'Endava')
	 */
	public void addEmployee(){}

	/**
	 * Remove an employee from a project which has 'John Doe' as project manager.
	 */
	public void removeEmployee(){}

}
