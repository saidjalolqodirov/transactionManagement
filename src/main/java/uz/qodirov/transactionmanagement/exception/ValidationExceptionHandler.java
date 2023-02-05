package uz.qodirov.transactionmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:40 AM
 */
@ControllerAdvice
public class ValidationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public String handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getConstraintViolations().forEach(cv -> {
            errors.put("message", cv.getMessage());
            errors.put("path", (cv.getPropertyPath()).toString());
        });

        return errors;
    }
}
