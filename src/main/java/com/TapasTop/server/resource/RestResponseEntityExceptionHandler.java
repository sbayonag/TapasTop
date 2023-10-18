package com.TapasTop.server.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({UserNotFoundException.class})
  public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
    return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.FORBIDDEN);
  }

}
