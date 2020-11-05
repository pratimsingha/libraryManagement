package com.kaha.library.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ErrorHandlerLibrary {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException e, WebRequest w){
        GlobalException globalException = new GlobalException(HttpStatus.BAD_REQUEST,e.getMessage());
        return new ResponseEntity(globalException,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLCustomException.class)
    public ResponseEntity<?> handleSQLCustomException(SQLCustomException e, WebRequest w){
        GlobalException globalException = new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        return new ResponseEntity(globalException,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleOtherException(Exception e, WebRequest w){
        GlobalException globalException = new GlobalException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        return new ResponseEntity(globalException,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
