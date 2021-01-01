package com.twtasks.emp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class EmployeeEntity {
	@Id
	@Column(name="empid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pho")
	private String pho;
	
	@Column(name="address")
	private String address;
	
	@CreationTimestamp
	@Column(name="createddate",updatable=false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@UpdateTimestamp
	@Column(name="updateddate",insertable=false)
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
		

	}

