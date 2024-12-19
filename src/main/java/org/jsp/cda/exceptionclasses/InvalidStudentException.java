package org.jsp.cda.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvalidStudentException extends RuntimeException{
	
	private String message;

}