package vn.vissoft.sc.exception;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vn.vissoft.sc.dto.response.Response;
import vn.vissoft.sc.dto.response.ResponseBody;
import javax.validation.ConstraintViolation;

/**
 * * @author : vinhtq
 * use this annotation to get paging and sorting parameter
 */

@Log4j2
@RestControllerAdvice
public class BaseErrorHandlers extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        log.error("MethodArgumentNotValid Exception: ", ex);
        return new ResponseEntity<>(new ResponseBody(Response.PARAM_NOT_VALID, errors), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";

        log.error("MissingServletRequestParameter Exception: ", ex);
        return new ResponseEntity<>(new ResponseBody(Response.MISSING_PARAM, error), HttpStatus.OK);
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": " + violation.getMessage());
        }

        log.error("ConstraintViolation Exception: ", ex);
        return new ResponseEntity<>(new ResponseBody(Response.PARAM_NOT_ACCEPT, errors), HttpStatus.OK);
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
        String error = ex.getName() + " should be of type in " + ex.getRequiredType();

        log.error("MethodArgumentTypeMismatch Exception: ", ex);
        return new ResponseEntity<>(new ResponseBody(Response.PARAM_NOT_ACCEPT, error), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers,
                                                                      HttpStatus status, WebRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getMethod());
        builder.append(" method is not supported for this request. Supported methods are ");

        if(ex.getSupportedHttpMethods() != null) {
            ex.getSupportedHttpMethods().forEach(t -> builder.append(t).append(" "));
        }

        log.error("HttpMethodNotSupported Exception: ", ex);
        return new ResponseEntity<>(new ResponseBody(Response.NOT_SUPPORT_MEDIA_TYPE, ex.getLocalizedMessage(), builder.toString()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getContentType());
        builder.append(" media type is not supported. Supported media types are ");
        ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));

        log.error("HttpMediaTypeNotSupported Exception: ", ex);
        return new ResponseEntity<>(new ResponseBody(Response.NOT_SUPPORT_MEDIA_TYPE, builder.substring(0, builder.length() - 2)), HttpStatus.OK);
    }

    @ExceptionHandler({ CommonException.class })
    public ResponseEntity<Object> handleCommonException(CommonException ex) {
        log.error("An exception have been throw: ", ex);
        return new ResponseEntity<>(new ResponseBody(ex.getResponse().getResponseCode(), ex.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception e, WebRequest request) {
        log.error("An error occurred: ", e);
        return new ResponseEntity<>(new ResponseBody(Response.SYSTEM_ERROR), HttpStatus.OK);
    }
}
