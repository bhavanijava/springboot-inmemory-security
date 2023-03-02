package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Employee;
import com.web.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to spring boot security";
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String admin()
	{
		return "Welcome Admin";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String user()
	{
		return "Welcome user";
	}
	
	
	
	@PostMapping("/save")
	public Employee save(@RequestBody Employee ed)
	{
		return service.save(ed);
	}
	
	@GetMapping("/findAll")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<Employee> findAll()
	{
		return service.findAll();
	}
	
	@GetMapping("/getOne/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Employee getOne(@PathVariable Integer id)
	{
		return service.getOne(id);
	}

}
