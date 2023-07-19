package com.dz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz.app.entity.Employee;
import com.dz.app.service.EmployeeService;

@RestController
@RequestMapping("adpemployee")
public class EmployeeMasterController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getEmployees();
	}
	
	@GetMapping(value="{eid}")
	public Employee getAllEmployeeByEid(@PathVariable("eid") Long eid){
		return employeeService.getEmployeeByEid(eid);
	}
	
	@GetMapping(value="{pagenumber}/{pagesize}")
	public List<Employee> getAllEmployeeByEid(@PathVariable("pagenumber") Integer pageNumber,
			@PathVariable("pagesize") Integer pageSize){
		return employeeService.getEmployeesByPage(pageNumber, pageSize);
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("{eid}")
	public Boolean deleteEmployee(@PathVariable("eid") Long eid) {
		return employeeService.deleteEmployee(eid);
	}
}
