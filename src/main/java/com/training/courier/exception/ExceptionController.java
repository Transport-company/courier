package com.training.courier.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionController extends ResponseEntityExceptionHandler {

    private static final String TIMESTAMP = "Timestamp";
    private static final String STATUS = "Status";
    private static final String ERRORS = "Error";
    private static final String TYPE = "Type";
    private static final String PATH = "Path";
    private static final String MESSAGE = "Message";
    private static final String DELIMITER = ": ";

    @ExceptionHandler(CourierNotFoundException.class)
    public ResponseEntity<Object> handlerCourierNotFoundException(
            CourierNotFoundException ex,
            WebRequest request) {

        return getExceptionResponseEntity(ex, HttpStatus.NOT_FOUND, request, List.of());
    }

    @ExceptionHandler(CourierAlreadyExistsException.class)
    public ResponseEntity<Object> handlerCourierAlreadyExistsException(
            CourierAlreadyExistsException ex,
            WebRequest request) {

        return getExceptionResponseEntity(ex, HttpStatus.CONFLICT, request, List.of());
    }

    @ExceptionHandler(DeliveryNotFoundException.class)
    public ResponseEntity<Object> handlerDeliveryNotFoundException(
            DeliveryNotFoundException ex,
            WebRequest request) {

        return getExceptionResponseEntity(ex, HttpStatus.NOT_FOUND, request, List.of());
    }

    @ExceptionHandler(CodeVerificationFailException.class)
    public ResponseEntity<Object> handlerCodeVerificationFailException(
            CodeVerificationFailException ex,
            WebRequest request) {

        return getExceptionResponseEntity(ex, HttpStatus.BAD_REQUEST, request, List.of());
    }

    private ResponseEntity<Object> getExceptionResponseEntity(
            final Exception ex,
            final HttpStatus status,
            final WebRequest request,
            final List<String> errors) {
        final Map<String, Object> body = new LinkedHashMap<>();
        final String path = request.getDescription(false);

        body.put(TIMESTAMP, LocalDateTime.now());
        body.put(STATUS, status.value());
        if (isNotEmpty(errors)) {
            body.put(ERRORS, errors);
        }
        body.put(TYPE, ex.getClass().getSimpleName());
        body.put(PATH, path);
        body.put(MESSAGE, ex.getMessage());

        log.error(ex.getMessage());

        return new ResponseEntity<>(body, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<String> validationErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> e.getField() + DELIMITER + e.getDefaultMessage())
                .collect(Collectors.toList());

        return getExceptionResponseEntity(ex, HttpStatus.BAD_REQUEST, request, validationErrors);
    }
}