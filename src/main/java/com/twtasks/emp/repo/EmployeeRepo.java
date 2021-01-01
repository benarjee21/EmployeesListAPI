package com.twtasks.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twtasks.emp.entities.EmployeeEntity;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer>{
	

}
