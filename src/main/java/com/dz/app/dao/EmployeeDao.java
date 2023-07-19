package com.dz.app.dao;

import java.util.List;

import com.dz.app.entity.Employee;

public interface EmployeeDao {


	Long saveEmployee(Employee employee);
	void updateEmployee(Employee empTrn);
	void deleteEmployee(Employee empTrn);
	Employee findById(Long eid);
	List<Employee> getAllEmployees();
	List<Employee> getEmployeeByPage(Integer pageVal, Integer pageSize);
}
