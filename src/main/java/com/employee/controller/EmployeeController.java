package com.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.employee.basedto.BaseDTO;
import com.employee.basedto.HexaDTO;
import com.employee.basedto.ResponseDTO;
import com.employee.entity.EmployeeModel;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;


@RestController("EmployeeController")
@Tag(name = "employee", description ="This contains all details of employee")
@CrossOrigin(origins = "*", maxAge = 3600)
@Log4j2
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@Operation(summary = "Add Student")
	@PostMapping("/add")
	public BaseDTO addEmployee(@RequestParam("name") String name,@RequestParam("dob") String dob,@RequestParam("rollNo")String rollNo){
		
		log.info("<======================== Add Student =========================>   START");
		BaseDTO baseDTO = employeeservice.addEmployee(name,dob,rollNo);
	System.out.println(baseDTO);
		log.info("<======================== Add Student =========================>   END");
		return baseDTO;
	}
	
	
	@GetMapping("/fetch")
	public BaseDTO fetchEmployee() {
		BaseDTO basedto = employeeservice.fetchEmployee();
		return basedto;		
		
	}
	
	@GetMapping("/fetchbyId")
	public BaseDTO fetchById(@RequestParam("employee_id")Long employeeId) {
		System.out.println("controller call");

		BaseDTO basedto = employeeservice.fetchById(employeeId);
		return basedto;
		
	}
	
	@DeleteMapping("/deletebyId")
	public BaseDTO deleteById(@RequestParam("employee_id")Long employeeId) {
		
		BaseDTO basedto = employeeservice.deleteById(employeeId);
		return basedto;
		
	}
	
//	@GetMapping("/existsbyId")
//	public BaseDTO existsId(@RequestParam("employee_id")Long employeeID) {
//		BaseDTO basedto = employeeservice.existById(employeeID);
//		return basedto;
//		
//	
//	
//	
//}
	@GetMapping("/request")
	public HexaDTO conversion(@RequestParam("number")String number) {
		
		System.out.println("---------number-----------");
		HexaDTO hexadto = employeeservice.conversion(number);
		return hexadto;
			
		
	}
	
	@GetMapping("/response")
	public ResponseDTO responseConversion(@RequestParam("number")String number) {
		
		System.out.println("---------number-----------");
		ResponseDTO responsedto = employeeservice.responseConversion(number);
		return responsedto;
			
		
	}
	
}
