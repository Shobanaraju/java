package com.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.EmployeeModel;
import com.employee.entity.StudentMarks;
import com.employee.entity.UserDetailsModel;
@Repository
public interface UserRepository extends JpaRepository<UserDetailsModel, Long> {
	
	Optional<UserDetailsModel> findByEmail(String email);
    Optional<UserDetailsModel> findByNameOrEmail(String name, String email);
    Optional<UserDetailsModel> findByName(String name);
    Boolean existsByName(String name);
    Boolean existsByEmail(String email);
    
//    Optional<StudentMarks> findByEmployeeModel(EmployeeModel employeeModel);

}
