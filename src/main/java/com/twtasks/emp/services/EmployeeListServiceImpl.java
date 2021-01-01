package com.twtasks.emp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twtasks.emp.beans.Employee;
import com.twtasks.emp.entities.EmployeeEntity;
import com.twtasks.emp.repo.EmployeeRepo;

@Service
public class EmployeeListServiceImpl implements EmployeeListService {
	
	@Autowired
	private EmployeeRepo empRepo;


	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> listOfEmps=empRepo.findAll();
		List<Employee> listOfEmployees;
		//converting list of entity to list of contacts for presentation layer
		listOfEmployees = listOfEmps.stream().map(entity->{
			Employee c = new Employee();
			BeanUtils.copyProperties(entity, c);
			return c;
		}).collect(Collectors.toList());
		return listOfEmployees;
	}

	
	public void empRegister(Employee emp) {
		
		EmployeeEntity newEmp = new EmployeeEntity();
		BeanUtils.copyProperties(emp, newEmp);
		EmployeeEntity savedEmp =empRepo.save(newEmp);
		System.out.println(savedEmp.getName());//testing in console
	}

	
	public Employee getEmpById(Integer id) {
		Optional<EmployeeEntity> toUpdateEmp = empRepo.findById(id);
		 if(toUpdateEmp.isPresent()) {
			 EmployeeEntity emp = toUpdateEmp.get();
			 Employee em = new Employee();
			 BeanUtils.copyProperties(emp, em);
			 return em;
		 }
			return null;
	}


	public void deleteEmp(Integer id) {
		empRepo.deleteById(id);
	}

	

}
