package com.twtasks.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twtasks.emp.beans.Employee;
import com.twtasks.emp.services.EmployeeListService;

@RestController
@CrossOrigin(origins="*")
public class EmployeeController {
	
	@Autowired
	private EmployeeListService empService;
	
	//Getting List of all Employees
	@GetMapping("/viewAllEmployees")
	public List<Employee> getEmployees() {
		List<Employee> recivedEmployees = empService.getAllEmployees();
		return recivedEmployees;
	}
		
	//Adding Employee
	@PostMapping("/saveEmp")
	public String addEmployee(@RequestBody Employee emp) {
		empService.empRegister(emp);	
		return "Employee Added Successfully";
	}
	
	//Deleting Employee
	@DeleteMapping("/deleteEmp/{id}")
	public List<Employee> deleteContact(@PathVariable Integer id) {
		empService.deleteEmp(id);
		return empService.getAllEmployees();
	}
	
	//Updating Employee
	@PutMapping("/updateEmp")
	public List<Employee> updateEmployee(@RequestBody Employee c) {
		empService.empRegister(c);
		return empService.getAllEmployees();
	}
	

	//get employee by id
	@PostMapping("/employee/{id}")
	public Employee saveEmployee(@PathVariable Integer id) {
		Employee emp =empService.getEmpById(id);
		return emp;
	}

}
