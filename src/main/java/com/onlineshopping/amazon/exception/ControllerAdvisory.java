package com.onlineshopping.amazon.exception;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//import javax.validation.ConstraintViolationException;
//import javax.validation.UnexpectedTypeException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerAdvisory {


    @ExceptionHandler(SupplierException.class)
    ResponseEntity<String> SupplierException(SupplierException supplierException) {
        return new ResponseEntity<>(supplierException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductException.class)
    ResponseEntity<String> ProductException(ProductException productException) {
        return new ResponseEntity<>(productException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerException.class)
    ResponseEntity<String> CustomerException(CustomerException customerException) {
        return new ResponseEntity<>(customerException.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> ConstraintViolationException(ConstraintViolationException constraintViolationException) {
        System.out.println(constraintViolationException.getMessage());
        return new ResponseEntity<>(constraintViolationException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<List<String>> MethodArgumentValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<String> lst = new ArrayList<>();
        methodArgumentNotValidException.getFieldErrors().forEach(fieldError -> lst.add(fieldError.getDefaultMessage()));
        return new ResponseEntity<>(lst, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(UnexpectedTypeException.class)
    ResponseEntity<String> UnExpectedTypeException(UnexpectedTypeException unexpectedTypeException) {
        return new ResponseEntity<>(unexpectedTypeException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    ResponseEntity<String> SQLException(SQLException sqlException){
        return new ResponseEntity<>(sqlException.getMessage(),HttpStatus.BAD_REQUEST);
    }

}

