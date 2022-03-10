package br.com.letscode.bookstore.exception;


import br.com.letscode.bookstore.model.dto.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handlerBusinessException(BusinessException exception, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (exception.getType() == 1) {
            //
        }

        BookHttpError error = new BookHttpError(exception.getMessage(), status.name(), status.value());

        return handleExceptionInternal(exception, error, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        var validationMessage = "Validation errors found: ";
        List<String> errors = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorMessage(validationMessage)
                .errors(errors)
                .build();

        return handleExceptionInternal(ex, errorResponse, headers, HttpStatus.BAD_REQUEST,
                request);
    }


    @ExceptionHandler({TransactionSystemException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorResponse> handleConstraintViolation(Throwable ex) {
        var errors = new ArrayList<String>();
        var validationMessage = "Validation errors found: ";

        if (ex instanceof TransactionSystemException) {
            ex = ((TransactionSystemException) ex).getRootCause();
        }

        if (ex instanceof ConstraintViolationException) {
            var constraintViolation = (ConstraintViolationException) ex;
            var violations = constraintViolation.getConstraintViolations();

            for (ConstraintViolation<?> violation : violations) {
                errors.add(violation.getPropertyPath() + ": " + violation.getMessage());
            }
        }

        return new ResponseEntity<>(ErrorResponse.builder()
                .errorMessage(validationMessage)
                .errors(errors)
                .build(), HttpStatus.BAD_REQUEST);
    }
}
