package br.com.edmardesenv.springrest.exceptionhandler;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.edmardesenv.springrest.exception.BusinessException;

@ControllerAdvice
public class SpringRestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler({EmptyResultDataAccessException.class})
	private ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
		String userMessage = messageSource.getMessage("resource.notFound", null, LocaleContextHolder.getLocale());
		String developerMessage = ex.toString();
		List<Error> erro = Arrays.asList(new Error(userMessage, developerMessage));
		return handleExceptionInternal(ex, erro, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler({BusinessException.class})
	private ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {
		String userMessage = ex.getLocalizedMessage();
		String developerMessage = ex.toString();
		List<Error> erro = Arrays.asList(new Error(userMessage, developerMessage));
		return handleExceptionInternal(ex, erro, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	public static class Error {
		private String userMessage;
		private String developerMessage;
		
		public Error(String userMessage, String developerMessage) {
			this.userMessage = userMessage;
			this.developerMessage = developerMessage;
		}

		public String getUserMessage() {
			return userMessage;
		}

		public String getDeveloperMessage() {
			return developerMessage;
		}
		
	}
}
