package com.etres.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.etres.entity.Employee;
import com.etres.service.EmployeeDao;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping("/emps")
	public String emps(Map<String,Object> map) {
		Collection<Employee> data = employeeDao.getAll();
		map.put("emps", data);
		return "list";
	}
	
	@GetMapping("/emp")
	public String addEmp() {
		return "addemp";
	}
	
	@PostMapping("/emp")
	public String addEmp(Employee employee) {
		System.out.println(employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	

}
