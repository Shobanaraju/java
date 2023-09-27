package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.employee.basedto.BaseDTO;
import com.employee.basedto.MarksDTO;
import com.employee.service.StudentMarksService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;

@RestController("StudentMarksController")
@Tag(name = "employee", description ="This contains all details of employee")
@CrossOrigin(origins = "*", maxAge = 3600)
@Log4j2
public class StudentMarksController {
	
	@Autowired
	StudentMarksService studentmarksservice;
	
	@Operation(summary = "Add Marks")
	@PostMapping("/add/marks")
	public BaseDTO addMarks(@RequestParam("employeeId") Long employeeId,@RequestParam("name")String name,@RequestBody MarksDTO marksDTO){
		
		log.info("<======================== Add Marks =========================>   START");
		BaseDTO baseDTO = studentmarksservice.addMarks(employeeId,name,marksDTO);
	System.out.println(baseDTO);
		log.info("<======================== Add Marks =========================>   END");
		return baseDTO;
	}
	
	@GetMapping("/fetchMarks/byId")
	public BaseDTO fetchMarksById(@RequestParam("employeeId")Long employeeId) {
		log.info("<======================== Fetch Marks =========================>   START");
		BaseDTO baseDTO=studentmarksservice.fetchMarksById(employeeId);
		System.out.println(baseDTO);
		log.info("<======================== Fetch Marks =========================>   END");
		return baseDTO;
		
	}
	

}
