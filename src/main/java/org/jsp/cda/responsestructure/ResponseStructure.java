package org.jsp.cda.responsestructure;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStructure<T>{
	private int httpstatus;
	private String message;
	private T body;

}
