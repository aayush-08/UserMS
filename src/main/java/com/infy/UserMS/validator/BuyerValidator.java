package com.infy.UserMS.validator;

import com.infy.UserMS.dto.BuyerDTO;
import com.infy.UserMS.userexception.UserException;

public class BuyerValidator {
	public static void validate(BuyerDTO userDTO) throws UserException {
		if (!isValidUserName(userDTO.getName()))
			throw new UserException("Validator.INVALID_USERNAME");
		if (!isValidPassword(userDTO.getPassword()))
			throw new UserException("Validator.INVALID_PASSWORD");
		if (!isValidEmail(userDTO.getEmail()))
			throw new UserException("Validator.INVALID_EMAIL");
		if (!isValidMobileNumber(userDTO.getPhoneNo()))
			throw new UserException("Validator.INVALID_MOBILENO");
		
	}

	public static Boolean isValidUserName(String userName) {
		return (userName.matches("^[A-Za-z]+([ ][A-Za-z]+)*$")) ? true : false;
	}

	public static Boolean isValidPassword(String password) {
		return (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*#!@$%^&]).{7,20}$")) ? true : false;
	}

	public static Boolean isValidEmail(String email) {
		return email.matches("[\\w]+@[\\w]+\\.[\\w]+") ? true : false;
	}

	public static Boolean isValidMobileNumber(Long str) {
		return Long.toString(str).matches("^\\d{10}$") ? true : false;
	}


}
