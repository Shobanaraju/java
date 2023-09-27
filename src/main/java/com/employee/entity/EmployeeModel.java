package com.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employeedetails")

public class EmployeeModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="employee_id" )
	private Long employeeId;
	
	private String name;
	
//	private String address;
	
//	private Float salary;
//	
//	private String  number;
	
	private String rollNo;
	
	private String dob;

}
