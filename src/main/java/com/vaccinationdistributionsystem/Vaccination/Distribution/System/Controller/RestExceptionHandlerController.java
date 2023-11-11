package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Controller;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DRO.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> invalidInput(MethodArgumentNotValidException e)
    {
        Response response=new Response(HttpStatus.BAD_REQUEST.toString(),e.getBindingResult().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> exceptionReceived(Exception e)
    {
        Response response=new Response(HttpStatus.BAD_REQUEST.toString(),e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
