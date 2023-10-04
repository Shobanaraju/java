package com.employee.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.employee.basedto.BaseDTO;
import com.employee.basedto.LoginRequest;
import com.employee.basedto.SignUpDTO;

import com.employee.entity.RegisterModel;

import com.employee.entity.UserDetailsModel;
import com.employee.repository.RegisterSignUpRepository;
import com.employee.repository.UserRepository;

import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class RegisterSignUpService {
	
	@Autowired
	RegisterSignUpRepository registersignuprepository;
	
	@Autowired
	UserRepository userrepository;
	
	
	
	public BaseDTO registerUser(SignUpDTO signUpDTO) {
	
		log.info("<======================== AuthService.registerUser =========================>   START");
		
		BaseDTO basedto = new BaseDTO();
		RegisterModel registermodel=new RegisterModel();
		
		registermodel.setName(signUpDTO.getName());
		registermodel.setEmail(signUpDTO.getEmail());
		registermodel.setPassword(signUpDTO.getPassword());
		
		
		registersignuprepository.save(registermodel);
		basedto.setResponseContent(registermodel);
		basedto.setMessage("Registered successfully");
		return basedto;
		
		
	}
	
	public BaseDTO authenticateUser(@Valid LoginRequest loginrequest ) {
		
		log.info("<======================== AuthService.authenticateUser =========================>   START");
		
		
		BaseDTO basedto = new BaseDTO();
		RegisterModel registermodel =registersignuprepository.findByEmail(loginrequest.getEmail()).get();
		
		RegisterModel registermodell =registersignuprepository.findByPassword(loginrequest.getPassword()).get();
		
		RegisterModel registermodelll=registersignuprepository.findByName(loginrequest.getName()).get();
		
		System.out.println(":::::::::::::::; Register Model :::::::::::::" + registermodel);
		
		
		
		UserDetailsModel userdetailsmodel = new UserDetailsModel();
//		
		
//		userdetailsmodel.setEmail(registermodel.getEmail());
//		userdetailsmodel.setPassword(registermodell.getPassword());
		
		userdetailsmodel.setEmail(loginrequest.getEmail());
		
		userdetailsmodel.setPassword(loginrequest.getPassword());
		
		userdetailsmodel.setName(loginrequest.getName());
		
		userrepository.save(userdetailsmodel);
//		
//		
		System.out.println(":::::::::::::::; userdetails Model :::::::::::::" + userdetailsmodel);
		
		
//		userrepository.setEmail(loginrequest.getEmail());
		
//		userrepository.save(userdetailsmodel);
		
		
		
		basedto.setResponseContent(registermodel);
		basedto.setMessage("login successfully");
		return basedto;
		
		

		
		


	}
	
	

}
