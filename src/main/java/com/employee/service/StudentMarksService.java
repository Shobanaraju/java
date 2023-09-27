package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.employee.basedto.BaseDTO;
import com.employee.basedto.MarksDTO;
import com.employee.entity.EmployeeModel;
import com.employee.entity.StudentMarks;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.MarksRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class StudentMarksService {

	@Autowired
	MarksRepository marksrepository;

	@Autowired
	EmployeeRepository employeerepository;

	public BaseDTO addMarks(Long employeeId, String name, MarksDTO marksDTO) {

		BaseDTO basedto = new BaseDTO();
		StudentMarks studentmarks = new StudentMarks();

		studentmarks.setEnglish(marksDTO.getEnglish());
		studentmarks.setMaths(marksDTO.getMaths());
		studentmarks.setScience(marksDTO.getScience());
		studentmarks.setSocial(marksDTO.getSocial());
		studentmarks.setTamil(marksDTO.getTamil());

		EmployeeModel employeemodel = employeerepository.findById(employeeId).get();

		String demo = employeemodel.getName();
		System.out.println(demo);
		studentmarks.setEmployeeModel(employeemodel);
		studentmarks.setName(demo);

		marksrepository.save(studentmarks);

		System.out.println(studentmarks);

		log.info("<======================== marks Added Service =========================>" + studentmarks);

		basedto.setResponseContent(studentmarks);
		basedto.setMessage("Marks added successfully");
		return basedto;

	}
	
	public BaseDTO fetchMarksById(Long employeeId) {
		
		EmployeeModel employeemodel =employeerepository.findById(employeeId).get();
		List<StudentMarks> studentmarks = marksrepository.findByEmployeeId(employeemodel);
		
		
		
//		Optional<StudentMarks> user = marksrepository.findByEmployee_Id(employee_id);
//		
		
//		Optional<StudentMarks> marksRepository.findByEmployee_Id(employee_id);
		
//		
//		RoleGroup roleGroup = groupRepository.findById(groupId).get();
//
//		List<ParentMenu> parentMenu = parentMenuRepository.findByRoleGroup(roleGroup);
//
//		return new BaseDTO(200, "Data fetched successfully", parentMenu);
////		
		
		
		System.out.println(employeeId);
//		System.out.println(user);
		return new BaseDTO(200, "Marks fetched successfully");
		
		
	}

	

	
}
