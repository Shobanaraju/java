package com.employee.service;

import java.util.ArrayList;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import com.employee.basedto.BaseDTO;
import com.employee.basedto.HexaDTO;
import com.employee.basedto.ResponseDTO;
import com.employee.controller.EmployeeController;
import com.employee.entity.EmployeeModel;
import com.employee.repository.EmployeeRepository;

import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class EmployeeService {
	
	
	@Autowired
	EmployeeRepository employeerepository;
	
	public BaseDTO addEmployee(String name, String dob,String rollNo) {
		
		BaseDTO basedto = new BaseDTO();
		EmployeeModel employeemodel = new EmployeeModel();
		employeemodel.setName(name);
		employeemodel.setDob(dob);
		employeemodel.setRollNo(rollNo);
		employeerepository.save(employeemodel);
		
		log.info("<======================== Student Added Service =========================>" +name +rollNo +dob);
		
		basedto.setResponseContent(employeemodel);
		basedto.setMessage("Student added successfully");
		return basedto;
	}
	
	
	public BaseDTO fetchEmployee() {
		
		List<EmployeeModel> list=employeerepository.findAllEmployee();
		
		
		return new BaseDTO(200, "Employee fetched successfully",list);
	}
	
	public BaseDTO fetchById(Long employeeId) {
	
	try {
		Optional<EmployeeModel> user = employeerepository.findById(employeeId);

		if (user.isPresent())
			return new BaseDTO(200, "User fetched successfully", user);
		else {
			return new BaseDTO(409, "User name doesn't exist");
		}

	} catch (Exception e) {
//		log.info("<============= fetchUserById method Exception calling ==============> " + e);
		return new BaseDTO(500, "Failure");
	}
//		
//		
//		
	}
	
	
	public BaseDTO deleteById(Long EmployeeId) {
		
		 employeerepository.deleteById(EmployeeId);
		return new BaseDTO(200,"Deleted Successfully");

}
	
	public HexaDTO conversion(String number) {
		
		 HexaDTO hexadto = new HexaDTO();
		
		String s1 = number;
//		System.out.println(s1.substring(0,2));
		
		
	// vendor code
		String s2 = s1.substring(0,2);
		int VendorCode = Integer.parseInt(s2,16);
        hexadto.setVendorCode(VendorCode);
        System.out.println("Vendor Key :" +VendorCode);

	//Routing key
		String s3 = s1.substring(2,10);
		int RoutingKey = Integer.parseInt(s3,16);
		hexadto.setRoutingKey(RoutingKey);
		System.out.println("Routing Key :" +RoutingKey);
		
		
	//Device type
		String s4 = s1.substring(10,14);
		int deviceType = Integer.parseInt(s4,16);
		hexadto.setDeviceType(deviceType);
		System.out.println("Device Typre :" +deviceType);
		
		
	// length
		String s5 = s1.substring(14,18);
		int length = Integer.parseInt(s5,16);
		hexadto.setLength(length);
		System.out.println("Length :" +length);
		
		
	//message type identifier
		String s6 = s1.substring(18,26);
		
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < s6.length(); i+=2) {
		    String str = s6.substring(i, i+2);
		    output.append((char)Integer.parseInt(str, 16));
		}		
		System.out.println(output.toString().trim());		
		String message = output.toString().trim();
		hexadto.setMessageTypeIdentifier(message);
		System.out.println("Message Type Identifier :" +message);
		
		
	//primaryBitmap
		String s7 =  s1.substring(26,42);
		
		String binaryValue = hexToBinary(s7);
        System.out.println("Hex: " + s7);
        System.out.println("Binary: " + binaryValue);     
        hexadto.setPrimaryBitmap(binaryValue);
        System.out.println("Primary Bitmap :" +binaryValue);
        
        //secondary Bitmap
        String s8 = s1.substring(42,58);
        String binary = hexToBinary(s8);
//        System.out.println("Hex: " + s7);
//        System.out.println("Binary: " + binary);     
        hexadto.setSecondaryBitmap(binary);
        System.out.println("Secondary Bitmap :" +binary);
        
        
       //REMAINING CONVERSION
      String s9 = s1.substring(58);
		
		StringBuilder outpu = new StringBuilder();
		for (int i = 0; i < s9.length(); i+=2) {
		    String str = s9.substring(i, i+2);
		    outpu.append((char)Integer.parseInt(str, 16));
		}
		String mess = outpu.toString().trim();
		hexadto.setConversion(mess);
		
		System.out.println("Remaining Conversion :" +mess);
		
	// Primary Acct No
		String acctNo = mess.substring(0,21);
		hexadto.setAcctNo(acctNo);
		System.out.println("Primary Acct No : " +acctNo);
		
	//Processing code
		String processingCode = mess.substring(21,27);
		hexadto.setProcessingCode(processingCode);
		System.out.println("Processing Code : " +processingCode);
		
	//Transmission Date and Time
		String dateTime = mess.substring(27,37);
		hexadto.setDateTime(dateTime);
		System.out.println("Transmission Date and Time : " +dateTime);
		
	//Trace Audit No
		String auditNo = mess.substring(37,43);
		hexadto.setAuditNo(auditNo);
		System.out.println("Trace Audit No : " +auditNo);
		
	//Transaction Time
		String transactionTime = mess.substring(43,49);
		hexadto.setTransactionTime(transactionTime);
		System.out.println("Transaction Time : " +transactionTime);
		
	//Transaction Date
		String transactionDate = mess.substring(49,53);
		hexadto.setTransactionDate(transactionDate);
		System.out.println("Transaction Date : " +transactionDate);
		
		
	//MCC
		String mcc = mess.substring(53,57);
		hexadto.setMcc(mcc);
		System.out.println("MCC : " +mcc);
		
	//Service Entry Mode
		String serviceEntry = mess.substring(57,60);
		hexadto.setServiceEntryMode(serviceEntry);
		System.out.println("Service Entry Mode :" +serviceEntry);
		
	//Service condition code
		String serviceCondition = mess.substring(60,62);
		hexadto.setServiceConditionCode(serviceCondition);
		System.out.println("Service Entry Mode :" +serviceCondition);
		
		//Acquiring Institution Identification Code
		String acquiringInstitution = mess.substring(62,70);
		hexadto.setIdentificationCode(acquiringInstitution);
		System.out.println("Acquiring Institution Identification Code :" +acquiringInstitution);
		
		
		//Retrieval reference no
		String refNo = mess.substring(70,82);
		hexadto.setReferenceNo(refNo);
		System.out.println("Retrieval reference no :" +refNo);
		
		//Card Acceptor Terminal Identification
		String terminalIdentification = mess.substring(82,90);
		hexadto.setCardAcceptorTerminal(terminalIdentification);
		System.out.println("Card Acceptor Terminal Identification :" +terminalIdentification);
		
		
		//Card Acceptor Identificatoion Code
		String identificationCode = mess.substring(90,105);
		hexadto.setCardAcceptorCode(identificationCode);
		System.out.println("Card Acceptor Identificatoion Code :" +identificationCode);
		
		
		//Card Acceptor Name/Location
		String acceptorName = mess.substring(105,145);
		hexadto.setCardAcceptorName(acceptorName);
		System.out.println("Card Acceptor Name/Location :" +acceptorName);
		
		//Encrypted and base-64 encoded personal identity data
		String personalIdentity = mess.substring(145,9221);
		hexadto.setPersonalIdentityData(personalIdentity);
		System.out.println("Card Acceptor Name/LocationEncrypted and base-64 encoded personal identity data :" +personalIdentity);     

	   //mc attribute data
		String attributeData = mess.substring(9221,10220);
		hexadto.setMcAttributeDate(attributeData);
		System.out.println("mc attribute data :" +attributeData);   
		
		//FIG Private Field
		String figData = mess.substring(10223,10623);
		hexadto.setFigPrivateField(figData);
		System.out.println("FIG Private Field :" +figData); 
		
		//Additional Data
		String addData = mess.substring(10623,10646);
		hexadto.setAdditionalData(addData);
		System.out.println("Additional Data :" +addData);
		
//		
		//Additional Data
		String addData1 = mess.substring(10646);
		hexadto.setAdditionalData1(addData1);
		System.out.println("Additional Data :" +addData1);
		
		
		
		
	            return hexadto;
		
		
		
	}
	
	 public static String hexToBinary(String hexValue) {
         // Create a BigInteger object from the hex string
         BigInteger bigInteger = new BigInteger(hexValue, 16);
         
         // Convert the BigInteger to binary string
         String binaryValue = bigInteger.toString(2);
         
         return binaryValue;
     }
	 
	 
	 //RESPONSE CONVERSION
	 
	 public ResponseDTO responseConversion(String number) {
			
		 ResponseDTO responsedto = new ResponseDTO();
		 
		 System.out.println("======Response Conversion=============");
		
		String s1 = number;
		
		// vendor code
				String s2 = s1.substring(0,2);
				int VendorCode = Integer.parseInt(s2,16);
				responsedto.setVendorCode(VendorCode);
		        System.out.println("Vendor Key :" +VendorCode);

			//Routing key
				String s3 = s1.substring(2,10);
				int RoutingKey = Integer.parseInt(s3,16);
				responsedto.setRoutingKey(RoutingKey);
				System.out.println("Routing Key :" +RoutingKey);
				
				
			//Device type
				String s4 = s1.substring(10,14);
				int deviceType = Integer.parseInt(s4,16);
				responsedto.setDeviceType(deviceType);
				System.out.println("Device Typre :" +deviceType);
				
				
			// length
				String s5 = s1.substring(14,18);
				int length = Integer.parseInt(s5,16);
				responsedto.setLength(length);
				System.out.println("Length :" +length);
				
				
			//message type identifier
				String s6 = s1.substring(18,26);
				
				StringBuilder output = new StringBuilder();
				for (int i = 0; i < s6.length(); i+=2) {
				    String str = s6.substring(i, i+2);
				    output.append((char)Integer.parseInt(str, 16));
				}		
				System.out.println(output.toString().trim());		
				String message = output.toString().trim();
				responsedto.setMessageTypeIdentifier(message);
				System.out.println("Message Type Identifier :" +message);
				
				
			//primaryBitmap
				String s7 =  s1.substring(26,42);
				
				String binaryValue = hexToBinary(s7);
//		        System.out.println("Hex: " + s7);
//		        System.out.println("Binary: " + binaryValue);     
				responsedto.setPrimaryBitmap(binaryValue);
		        System.out.println("Primary Bitmap :" +binaryValue);
		        
		     //secondary Bitmap
		        String s8 = s1.substring(42,58);
		        String binary = hexToBinary(s8);
//		        System.out.println("Hex: " + s7);
//		        System.out.println("Binary: " + binary);     
		        responsedto.setSecondaryBitmap(binary);
		        System.out.println("Secondary Bitmap :" +binary);
		        
		        
		        //REMAINING CONVERSION
		        String s9 = s1.substring(58);
		  		
		  		StringBuilder outpu = new StringBuilder();
		  		for (int i = 0; i < s9.length(); i+=2) {
		  		    String str = s9.substring(i, i+2);
		  		    outpu.append((char)Integer.parseInt(str, 16));
		  		}
		  		String mess = outpu.toString().trim();
		  		responsedto.setConversion(mess);
		  		
		  		System.out.println("Remaining Conversion :" +mess);
		  		
		  	// Primary Acct No
		  		String remainingll = mess.substring(0,2);
		  		System.out.println(remainingll);
		  		
		  		String acctNo = mess.substring(2,21);
		  		responsedto.setAcctNo(acctNo);
		  		System.out.println("Primary Acct No : " +acctNo);
		  		
		  	//Processing code
		  		String processingCode = mess.substring(21,27);
		  		responsedto.setProcessingCode(processingCode);
		  		System.out.println("Processing Code : " +processingCode);
		  		
		  	//Transmission Date and Time
		  		String dateTime = mess.substring(27,37);
		  		responsedto.setDateTime(dateTime);
		  		System.out.println("Transmission Date and Time : " +dateTime);
		  		
		  	//Trace Audit No
		  		String auditNo = mess.substring(37,43);
		  		responsedto.setAuditNo(auditNo);
		  		System.out.println("Trace Audit No : " +auditNo);
		  		
		  	//Transaction Time
		  		String transactionTime = mess.substring(43,49);
		  		responsedto.setTransactionTime(transactionTime);
		  		System.out.println("Transaction Time : " +transactionTime);
		  		
		  	//Transaction Date
		  		String transactionDate = mess.substring(49,53);
		  		responsedto.setTransactionDate(transactionDate);
		  		System.out.println("Transaction Date : " +transactionDate);
		  		
		  	//Acquiring Institution Identification Code
				String acquiringInstitution = mess.substring(53,61);
				responsedto.setIdentificationCode(acquiringInstitution);
				System.out.println("Acquiring Institution Identification Code :" +acquiringInstitution);
				
				
				//Retrieval reference no
				String refNo = mess.substring(61,73);
				responsedto.setReferenceNo(refNo);
				System.out.println("Retrieval reference no :" +refNo);
				
				//Response Code
				String responseCode = mess.substring(73,75);
				responsedto.setResponseCode(responseCode);
				System.out.println("Retrieval reference no :" +responseCode);
				

				//Card Acceptor Terminal Identification
				String terminalIdentification = mess.substring(75,83);
				responsedto.setCardAcceptorTerminal(terminalIdentification);
				System.out.println("Card Acceptor Terminal Identification :" +terminalIdentification);
				
				
				//Card Acceptor Identificatoion Code
				String identificationCode = mess.substring(83,98);
				responsedto.setCardAcceptorCode(identificationCode);
				System.out.println("Card Acceptor Identificatoion Code :" +identificationCode);
				
				
				//Card Acceptor Name/Location
				String acceptorName = mess.substring(98,138);
				responsedto.setCardAcceptorName(acceptorName);
				System.out.println("Card Acceptor Name/Location :" +acceptorName);
				
				
				//remaining
				String rel = mess.substring(138,141);
				System.out.println(rel);
//				
				//UIDAI Authentication Code
				String uidai = mess.substring(141,257);
				responsedto.setUidaiAuthenticationCode(uidai);
				System.out.println("/UIDAI Authentication Code :" +uidai);
				
//				
				String rell =mess.substring(257,260);
				System.out.println(rell);
				
				//FIG Private Field
				String fig = mess.substring(260,279);
				responsedto.setFigPrivateField(fig);
				System.out.println("/UIDAI Authentication Code :" +fig);
				
				
				
				
		        
		        
		return responsedto;
	 }
	


}
