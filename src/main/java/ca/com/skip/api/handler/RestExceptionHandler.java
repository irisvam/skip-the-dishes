package ca.com.skip.api.handler;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ca.com.skip.api.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(final ResourceNotFoundException rnfException) {
		
		final ErrorDetails errorDetails = ErrorDetails.Builder.newBuilder().timestamp(new Date().getTime()).status(HttpStatus.NOT_FOUND.value())
				.title("Resource Not Found").detail(rnfException.getMessage()).devMessage(rnfException.getClass().getName()).build();
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handlerNoSuchElementException(final NoSuchElementException rnfException) {
		
		final ErrorDetails errorDetails = ErrorDetails.Builder.newBuilder().timestamp(new Date().getTime()).status(HttpStatus.NOT_FOUND.value())
				.title("Resource Not Found").detail(rnfException.getMessage()).devMessage(rnfException.getClass().getName()).build();
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(final Exception exception, final Object body, final HttpHeaders headers,
			final HttpStatus status, final WebRequest request) {
		
		final ErrorDetails errorDetails = ErrorDetails.Builder.newBuilder().timestamp(new Date().getTime()).status(status.value())
				.title("Erro na requisição interna!").detail(exception.getMessage()).devMessage(exception.getClass().getName()).build();
		
		return new ResponseEntity<>(errorDetails, headers, status);
	}
	
}
