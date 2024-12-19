package org.jsp.cda.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvalidCredentialException extends RuntimeException {
	
	String message;

	@Override
	public String getMessage() {
		return this.getMessage();
	}

}
