package com.employee.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.employee.entity.EmployeeModel;
import com.employee.entity.StudentMarks;

@Repository
public interface MarksRepository extends JpaRepository<StudentMarks, Long> {
	
//	StudentMarks findByemployee_id(Long employee_id);
//	Optional<StudentMarks> findByEmployee_Id(Long employee_id);
	
//	@Query("select * from StudentMarks s where s.employee_id = :employee_id") 
//	StudentMarks findByEmployee_Id(long employee_id);
	
	
	List<StudentMarks> findByEmployeeId(EmployeeModel employeemodel);

}
