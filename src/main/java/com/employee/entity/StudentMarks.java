package com.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name = "studentmarks")
public class StudentMarks {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="sub_id" )
	private Integer subId;

	private Integer english;
	
	private Integer maths;
	
	private Integer science;
	
	private Integer social;
	
	private Integer tamil;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	private EmployeeModel employeeModel;
	
	
	
}
