package com.dz.app.service;

import java.util.List;

import com.dz.app.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();
	public List<Employee> getEmployeesByPage(Integer pageVal, Integer pageSize);
	public Employee getEmployeeByEid(Long eid);
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public Boolean deleteEmployee(Long eid);
}
