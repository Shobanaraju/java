package com.employee.basedto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;



@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/** e@Datarror code. 0 if success else unique error code value */

	Integer statusCode;

	String message;
	List<?> keys;

	Object responseContent;

	List<?> responseContents;

//	String Username;
//	String Password;
//	String cookie;
	String data;
	String status;

//	String errorDescription;

	public BaseDTO() {

	}

	public BaseDTO(Integer statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public BaseDTO(Integer statusCode, String message, Object responseContent) {
		this.statusCode = statusCode;
		this.message = message;
		this.responseContent = responseContent;
	}
}
