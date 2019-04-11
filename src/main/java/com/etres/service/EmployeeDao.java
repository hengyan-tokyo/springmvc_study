package com.etres.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.etres.entity.Employee;

@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;
	
	
	static{
		employees = new HashMap<Integer, Employee>();

		employees.put(1001, new Employee(1001, "E-AA", "aa001@163.com", 1 ));
		employees.put(1002, new Employee(1002, "E-BB", "bb002@163.com", 1 ));
		employees.put(1003, new Employee(1003, "E-CC", "cc003@163.com", 0 ));
		employees.put(1004, new Employee(1004, "E-DD", "dd004@163.com", 0 ));
		employees.put(1005, new Employee(1005, "E-EE", "ee005@163.com", 1 ));
	}
	
	private static Integer initId = 8006;
	
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		employees.put(employee.getId(), employee);
	}

	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	
	public void delete(Integer id){
		employees.remove(id);
	}
}
