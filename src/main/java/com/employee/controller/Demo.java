package com.employee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "auth", description = "This contains all details of upi")
@ApiResponse(responseCode = "200", description = "Success")
@ApiResponse(responseCode = "401", description = "You are not authorized to view the resource")
@ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden")
@ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
@ApiResponse(responseCode = "409", description = "Conflict occurred")

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("")

public class Demo {
	
	@Operation(summary = "User info")

	@GetMapping("/userInfo")
	public String passwordReset() {

		String msg = "welcome";
		
		

		
		
		return msg;
	}
	
	

}
