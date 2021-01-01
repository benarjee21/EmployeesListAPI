package com.twtasks.emp.services;

import java.util.List;


import com.twtasks.emp.beans.Employee;

public interface EmployeeListService {

		public List<Employee> getAllEmployees();
		public void empRegister(Employee emp);
		public Employee getEmpById(Integer id);
		public void deleteEmp(Integer id);

}


