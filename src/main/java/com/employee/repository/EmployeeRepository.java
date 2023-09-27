package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.basedto.BaseDTO;
import com.employee.entity.EmployeeModel;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{
	
	@Query(value = "SELECT * FROM employeedetails", nativeQuery = true)
	List<EmployeeModel> findAllEmployee();

	@Query(value = "SELECT * FROM employeedetails", nativeQuery = true)
	BaseDTO save(String number);
	
	
}

