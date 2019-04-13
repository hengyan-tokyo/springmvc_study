package com.etres.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	public String toaddEmpPage() {
		return "addemp";
	}
	
	@PostMapping("/emp")
	public String addEmp(Employee employee) {
		System.out.println(employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@GetMapping("/emp/{empId}")
	public String toEditEmpPage(@PathVariable("empId")Integer empId,Map<String,Object> map) {
		Employee employee = employeeDao.get(empId);
		System.out.println("�޸�Ա��ǰ����:"+employee);
		map.put("emp", employee);
		return "addemp";
	}
	
	@PutMapping("emp")
	public String updateEmp(Employee emp) {
		
		System.out.println("�޸�Ա��������:"+emp);
		employeeDao.save(emp);
		return "redirect:/emps";
	}
	
	@DeleteMapping("/emp/{empId}")
	public String deleteEmp(@PathVariable("empId")Integer id) {
		employeeDao.delete(id);
		System.out.println("ɾ����Ա������:"+employeeDao.get(id));
		return "redirect:/emps";
	}
	

}
