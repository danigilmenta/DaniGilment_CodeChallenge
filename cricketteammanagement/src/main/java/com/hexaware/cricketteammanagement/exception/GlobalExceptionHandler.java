
package com.hexaware.cricketteammanagement.exception;
import com.hexaware.cricketteammanagement.exception.PlayerNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PlayerNotFoundException.class)
	public String handlePlayerNotFound(PlayerNotFoundException ex) {
	    return ex.getMessage();
	}
}