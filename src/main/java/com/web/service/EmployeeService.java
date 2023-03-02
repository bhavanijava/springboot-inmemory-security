package com.web.service;

import java.util.List;

import com.web.model.Employee;

public interface EmployeeService {

	public Employee save(Employee e);
	public List<Employee> findAll();
	public Employee getOne(Integer id);
}
