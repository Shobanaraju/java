package com.employee.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.employee.basedto.BaseDTO;
import com.employee.basedto.LoginRequest;
import com.employee.basedto.SignUpDTO;
import com.employee.service.RegisterSignUpService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;

@RestController("SignUpController")
@Tag(name = "employee", description ="This contains all details of employee")
@CrossOrigin(origins = "*", maxAge = 3600)
@Log4j2


public class registerController {
	
	@Autowired
	RegisterSignUpService registersignupservice;
	
	
	@Operation(summary = "User signup")
	@PostMapping("/signup")
	public BaseDTO SignupUser(@RequestBody SignUpDTO signUpDTO){

		log.info("<======================== AuthController.registerUser =========================>   START");
		BaseDTO baseDTO = registersignupservice.registerUser(signUpDTO);
		log.info("<======================== AuthController.registerUser =========================>   END");

		return baseDTO;
	}
	
	@Operation(summary = "User signin")
	@PostMapping("/signin")
	public BaseDTO authenticateUser(@Valid @RequestBody LoginRequest loginrequest) {

		log.info("<======================== AuthController.authenticateUser =========================>   START");
		BaseDTO baseDTO = registersignupservice.authenticateUser(loginrequest);
		log.info("<======================== AuthController.authenticateUser =========================>   END");

		return baseDTO;
	}

}
