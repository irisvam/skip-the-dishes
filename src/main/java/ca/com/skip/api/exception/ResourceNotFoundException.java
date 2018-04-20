package ca.com.skip.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1385397483678856248L;
	
	public ResourceNotFoundException(final String message) {
		
		super(message);
	}
	
}
