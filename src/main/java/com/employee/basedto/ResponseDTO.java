package com.employee.basedto;

import lombok.Data;

@Data
public class ResponseDTO {
	
	private Integer vendorCode;
	
	private Integer routingKey;
	
	private Integer deviceType;
	
	private Integer length;
	
	private String messageTypeIdentifier;
	
	private String primaryBitmap;
	
	private String secondaryBitmap;
	
	private String conversion;
	
	private String acctNo;
	
	private String processingCode;
	
	private String dateTime;
	
	private String auditNo;
	
	private String transactionTime;
	
	private String transactionDate;
	
	private String identificationCode;
	
	private String referenceNo;
	
	private String responseCode;
	
	private String cardAcceptorTerminal;
	
	private String cardAcceptorCode;
	
	private String cardAcceptorName;
	
	private String uidaiAuthenticationCode;
	
	private String figPrivateField;

}
