package com.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.EmployeeModel;
import com.employee.entity.RegisterModel;
import com.employee.entity.StudentMarks;
import com.employee.entity.UserDetailsModel;

@Repository
public interface RegisterSignUpRepository extends JpaRepository<RegisterModel,Long> {
	
	
	Optional<RegisterModel> findByEmail(String email);
	
	Optional<RegisterModel> findByPassword(String password);
	
	Optional<RegisterModel> findByName(String name);
	
	
	
	
	

}
