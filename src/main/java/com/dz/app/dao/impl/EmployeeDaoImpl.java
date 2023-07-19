package com.dz.app.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dz.app.dao.EmployeeDao;
import com.dz.app.entity.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private HibernateTemplate template;
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	@Transactional
	@Override
	public Long saveEmployee(Employee employee) {
		return (Long)this.template.save(employee);
	}

	@Transactional
	@Override
	public void updateEmployee(Employee empTrn) {
		this.template.saveOrUpdate(empTrn);
	}

	@Transactional
	@Override
	public void deleteEmployee(Employee empTrn) {
		this.template.delete(empTrn);
	}

	@Override
	public Employee findById(Long eid) {
		return this.template.get(Employee.class, eid);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return this.template.loadAll(Employee.class);
	}

	@Override
	public List<Employee> getEmployeeByPage(Integer pageVal, Integer pageSize) {
		
//		Session openSession = this.template.getSessionFactory().openSession();
		try(Session session =  this.template.getSessionFactory().openSession()) {
		
			Query<Employee>  query=session.createQuery("from Employee order by eid desc",Employee.class);
			
			query.setFirstResult(pageVal);
			query.setMaxResults(pageSize);
			
			List<Employee> employees=query.getResultList();
			
			return employees;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
