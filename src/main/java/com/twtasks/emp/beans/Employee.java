package com.twtasks.emp.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	private int empid;
	private String name;
	private String email;
	private String pho;
	private String address;

}
