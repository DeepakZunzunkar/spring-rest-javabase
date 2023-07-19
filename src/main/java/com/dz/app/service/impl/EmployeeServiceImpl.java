package com.dz.app.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dz.app.dao.EmployeeDao;
import com.dz.app.entity.BaseProperties;
import com.dz.app.entity.Employee;
import com.dz.app.service.EmployeeService;
import com.dz.app.utility.Constant.EmployeeStatus;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getEmployees() {

		List<Employee> allEmployees = employeeDao.getAllEmployees().stream().sorted().collect(Collectors.toList());
		long count = allEmployees.stream().count();
		System.out.println("Count " + count);
		return allEmployees;
	}

	@Override
	public List<Employee> getEmployeesByPage(Integer pageVal, Integer pageSize) {
		return employeeDao.getEmployeeByPage(pageVal, pageSize);
	}

	@Override
	public Employee getEmployeeByEid(Long eid) {
		return employeeDao.findById(eid);
	}

	@Override
	public Employee addEmployee(Employee trn) {

		trn.setBaseProperties(new BaseProperties("A", new Date(), "spring-rest-javabase", null, null));
		trn.setStatus(EmployeeStatus.ACTIVE.getEmployeeStatusCode());
		employeeDao.saveEmployee(trn);
		return trn;

	}

	@Override
	public Employee updateEmployee(Employee trn) {

		if (trn.getEid() != null) {

			Employee trnSql = getEmployeeByEid(trn.getEid());

			trnSql.getBaseProperties().setUpdatedBy("spring-rest-javabase");
			trnSql.getBaseProperties().setUpdatedOn(new Date());

			trnSql.setFirstName(trn.getFirstName());
			trnSql.setMiddleName(trn.getMiddleName());
			trnSql.setLastName(trn.getLastName());
			trnSql.setStatus(trn.getStatus());
			trnSql.setGender(trn.getGender());
			trnSql.setBirthDate(trn.getBirthDate());
			trnSql.setSalary(trn.getSalary());
			
			employeeDao.updateEmployee(trnSql);
			return trnSql;
		}
		return null;
	}

	@Override
	public Boolean deleteEmployee(Long eid) {
		
		Employee sqlEmp = getEmployeeByEid(eid);
		if(sqlEmp !=null) {
			this.employeeDao.deleteEmployee(sqlEmp);
		}
		return sqlEmp!=null? true:false;
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
}
