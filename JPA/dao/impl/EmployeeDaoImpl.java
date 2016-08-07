package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.Dao;
import com.endava.jpa.dao.EmployeeDao;
import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private String QUERY_FIND_EMPLOYEE_BY_NAME = "Select e from Employee e where e.name = :emp_name";
    private String QUERY_FIND_EMPLOYEE_BY_DEPT_AND_CITY =
            "Select e from Employee e where e.department.id = :id and e.city like :city";

	@PersistenceContext
	private EntityManager entityManager;

    public Employee find(int id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> find(String employeeName) {
        return entityManager.createQuery(QUERY_FIND_EMPLOYEE_BY_NAME)
                .setParameter("emp_name", employeeName)
                .getResultList();
    }

    public List<Employee> getEmployeeByDeptAndCity(int id, String city) {
        return entityManager.createQuery(QUERY_FIND_EMPLOYEE_BY_DEPT_AND_CITY)
                .setParameter("id", id)
                .setParameter("city", city)
                .getResultList();
    }

    public void save(Employee toBeSaved) {
        entityManager.persist(toBeSaved);
        entityManager.flush();
    }

    public void update(Employee toBeUpdated) {
        Employee mergedEmployee = entityManager.merge(toBeUpdated);
        mergedEmployee.setName("John-Testing");
    }

    public void remove(Employee toBeRemoved) {
        entityManager.remove(entityManager.merge(toBeRemoved));
    }
}
