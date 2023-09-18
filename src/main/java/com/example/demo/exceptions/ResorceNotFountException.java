package com.example.demo.exceptions;

public class ResorceNotFountException extends RuntimeException {
	
	String ResourceName;
	String FieldName;
	long FieldValue;
	public ResorceNotFountException(String resourceName, String fieldName, long fieldValue) {
		super(resourceName + " Not Fond with "+  fieldName  + " id "+ fieldValue);
		ResourceName = resourceName;
		FieldName = fieldName;
		FieldValue = fieldValue;
	}
	
	
	

}
