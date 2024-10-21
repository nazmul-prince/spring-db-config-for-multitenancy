package com.demo.multitenancy.infrastructure.configuration;

import com.demo.multitenancy.core.domain.model.ErrorResponse;
import com.demo.multitenancy.core.shared.exceptions.BadRequestException;
import com.demo.multitenancy.core.shared.exceptions.ConflictException;
import com.demo.multitenancy.core.shared.exceptions.DataNotFoundException;
import com.demo.multitenancy.core.shared.exceptions.ForbiddenException;
import com.demo.multitenancy.core.shared.exceptions.InternalServerErrorException;
import com.demo.multitenancy.core.shared.exceptions.UnauthorizedException;
import com.demo.multitenancy.infrastructure.utils.ExceptionUtils;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception genericException) {
        logErrorWithExceptionDetails(genericException, HttpStatus.INTERNAL_SERVER_ERROR);
        ErrorResponse genericExceptionErrorResponse = createErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR, genericException.getMessage(), genericException);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(genericExceptionErrorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException
    ) {
        logErrorWithExceptionDetails(methodArgumentNotValidException, HttpStatus.BAD_REQUEST);

        FieldError fieldError = methodArgumentNotValidException.getFieldErrors().get(0);
        String message = fieldError.getField() + " ইনপুট সঠিক নয় । অনুগ্রহ করে আবার চেষ্টা করুন ।";

        if (methodArgumentNotValidException.getMessage().contains("size must be between")) {
            String fieldNameRegEx = ".*on field '([^']+)'.*";
            String rangeRegEx = "size must be between (\\d+) and (\\d+)";

            Pattern fieldNamePattern = Pattern.compile(fieldNameRegEx);
            Pattern rangePattern = Pattern.compile(rangeRegEx);

            // Create a Matcher object
            Matcher fieldNameMatcher = fieldNamePattern.matcher(
                    methodArgumentNotValidException.getMessage());
            Matcher rangeMatcher = rangePattern.matcher(
                    methodArgumentNotValidException.getMessage());

            if (fieldNameMatcher.find() && rangeMatcher.find()) {
                String upperBound = rangeMatcher.group(2);
                String fieldName = fieldNameMatcher.group(1);
                message = fieldName + " ইনপুটটির আকার অবশ্যই " + upperBound
                        + " টি ক্যারেক্টার এর কম বা সমান হতে হবে ৷ অনুগ্রহ করে কম দৈর্ঘ্যের ইনপুট"
                        + " দিন ।";
            }
        }

        ErrorResponse methodArgumentNotValidExceptionErrorResponse =
                createErrorResponse(
                        HttpStatus.BAD_REQUEST,
                        message,
                        methodArgumentNotValidException
                );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(methodArgumentNotValidExceptionErrorResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(
            ConstraintViolationException constraintViolationException
    ) {
        logErrorWithExceptionDetails(constraintViolationException, HttpStatus.BAD_REQUEST);
        ErrorResponse methodArgumentNotValidExceptionErrorResponse =
                createErrorResponse(
                        HttpStatus.BAD_REQUEST,
                        constraintViolationException.getMessage(),
                        constraintViolationException
                );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(methodArgumentNotValidExceptionErrorResponse);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException ex
    ) {
        logErrorWithExceptionDetails(ex, HttpStatus.BAD_REQUEST);
        ErrorResponse errorResponse = createErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Invalid request data: " + ex.getMessage(),
                ex
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(
            DataIntegrityViolationException ex
    ) {
        logErrorWithExceptionDetails(ex, HttpStatus.BAD_REQUEST);
        ErrorResponse errorResponse = createErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Data integrity violation occurred: " + ex.getMessage(),
                ex
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorResponse> handleInternalServerErrorException(
            InternalServerErrorException internalServerErrorException
    ) {
        logErrorWithExceptionDetails(
                internalServerErrorException, HttpStatus.INTERNAL_SERVER_ERROR);
        ErrorResponse internalServerErrorExceptionResponse = createErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR, internalServerErrorException.getMessage(),
                internalServerErrorException
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(internalServerErrorExceptionResponse);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorResponse> handleForbiddenException(
            ForbiddenException forbiddenException
    ) {
        logErrorWithExceptionDetails(forbiddenException, HttpStatus.FORBIDDEN);
        ErrorResponse forbiddenExceptionErrorResponse = createErrorResponse(HttpStatus.FORBIDDEN,
                                                                            forbiddenException.getMessage(),
                                                                            forbiddenException
        );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(forbiddenExceptionErrorResponse);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(
            BadRequestException badRequestException
    ) {
        logErrorWithExceptionDetails(badRequestException, HttpStatus.BAD_REQUEST);
        ErrorResponse badRequestExceptionErrorResponse = createErrorResponse(HttpStatus.BAD_REQUEST,
                                                                             badRequestException.getMessage(),
                                                                             badRequestException
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequestExceptionErrorResponse);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(
            DataNotFoundException notFoundException
    ) {
        logErrorWithExceptionDetails(notFoundException, HttpStatus.NOT_FOUND);
        ErrorResponse notFoundExceptionErrorResponse = createErrorResponse(HttpStatus.NOT_FOUND,
                                                                           notFoundException.getMessage(),
                                                                           notFoundException
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundExceptionErrorResponse);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(
            UnauthorizedException unauthorizedException
    ) {
        logErrorWithExceptionDetails(unauthorizedException, HttpStatus.UNAUTHORIZED);
        ErrorResponse unauthorizedExceptionErrorResponse = createErrorResponse(
                HttpStatus.UNAUTHORIZED,
                unauthorizedException.getMessage(), unauthorizedException
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                unauthorizedExceptionErrorResponse);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponse> handleConflictException(
            ConflictException conflictException
    ) {
        logErrorWithExceptionDetails(conflictException, HttpStatus.CONFLICT);
        ErrorResponse conflictExceptionErrorResponse = createErrorResponse(
                HttpStatus.CONFLICT, conflictException.getMessage(), conflictException
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(conflictExceptionErrorResponse);
    }

    private void logErrorWithExceptionDetails(Exception exception, HttpStatus httpStatus) {
        log.error("Exception: " + httpStatus, exception);
    }

    private ErrorResponse createErrorResponse(
            HttpStatus status, String message,
            Exception exception
    ) {
        return ErrorResponse.builder()
                .httpStatusCode(String.valueOf(status))
                .message(message)
                .timestamp(LocalDateTime.now())
                .errorStackTrace(ExceptionUtils.extractStacktrace(exception.getStackTrace()))
                .build();
    }

}


