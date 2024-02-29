package com.app.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.Exception.FlightNotFoundException;
import com.app.Exception.HotelNotFoundException;

public class MyControllerAdvice extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<String> handleBookingNotFoundException(FlightNotFoundException FlightNotFoundException) {
		return new ResponseEntity<String>("Booking Not Found, please send proper data", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<String> handleHotelNotFoundException(HotelNotFoundException hotelNotFoundException) {
		return new ResponseEntity<String>("Hotel Not Found, please send proper data", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
		return new ResponseEntity<String>("No Value is present in DB, Please change your request", HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>("Please change your Http Method type", HttpStatus.NOT_FOUND);
	}


}
