package com.ms.common.error;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

    @Autowired
    private ErrorConfig errconfig;

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final IllegalArgumentException exp) {
        return this.errconfig.buildBaseErrorObj()
                             .setMessage(exp.getMessage())
                             .setErrorCode(10203);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final MethodArgumentNotValidException exp) {
        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        ErrorObj rootError = this.errconfig.buildBaseErrorObj()
                                           .setMessage("Validation error")
                                           .setErrorCode(12300);
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            rootError.addSubError(this.errconfig.buildBaseErrorObj()
                                                .setMessage("" + objectErrorLoc)
                                                .setErrorCode(12301));
        }
        return rootError;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final ConstraintViolationException exp) {
        Set<ConstraintViolation<?>> allErrorsLoc = exp.getConstraintViolations();
        ErrorObj rootError = this.errconfig.buildBaseErrorObj()
                                           .setMessage("Validation error")
                                           .setErrorCode(12300);
        for (ConstraintViolation<?> objectErrorLoc : allErrorsLoc) {
            rootError.addSubError(this.errconfig.buildBaseErrorObj()
                                                .setMessage("" + objectErrorLoc)
                                                .setErrorCode(12301));
        }
        return rootError;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handleException(final Exception exp) {
        return this.errconfig.buildBaseErrorObj()
                             .setMessage(exp.getMessage())
                             .setErrorCode(15000);
    }

}
