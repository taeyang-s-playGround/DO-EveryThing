package practice.Practice.global.error;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import practice.Practice.global.error.exception.BusinessException;
import practice.Practice.global.error.exception.ErrorCode;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    //비즈니스 로직에서의 에러
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {

        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse response = ErrorResponse.of(errorCode, errorCode.getMessage());

        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatusCode()));
    }

    // validation 에러
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e) {

        ErrorCode errorCode = ErrorCode.BAD_REQUEST;
        ErrorResponse response = ErrorResponse.of(errorCode, errorCode.getMessage());

        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatusCode()));
    }
}
