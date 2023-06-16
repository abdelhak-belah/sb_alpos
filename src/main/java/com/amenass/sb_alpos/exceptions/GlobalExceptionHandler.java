package com.amenass.sb_alpos.exceptions;

import com.amenass.sb_alpos.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<ResponseUtil> badRequestException(BadRequestException badRequestException){
        return ResponseEntity.status(BAD_REQUEST).body(
                ResponseUtil.builder()
                        .timeStamp(now())
                        .reason(badRequestException.getMessage())
                        .status(BAD_REQUEST)
                        .statusCode(BAD_REQUEST.value())
                        .build()
        );
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ResponseUtil> notFoundException(NotFoundException notFoundException){
        return ResponseEntity.status(NOT_FOUND).body(
                ResponseUtil.builder()
                        .timeStamp(now())
                        .reason(notFoundException.getMessage())
                        .status(NOT_FOUND)
                        .statusCode(NOT_FOUND.value())
                        .build()
        );
    }

    @ExceptionHandler(value = {FailedException.class})
    public ResponseEntity<ResponseUtil> failedException(FailedException failedException){
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(
                ResponseUtil.builder()
                        .timeStamp(now())
                        .reason(failedException.getMessage())
                        .status(INTERNAL_SERVER_ERROR)
                        .statusCode(INTERNAL_SERVER_ERROR.value())
                        .build()
        );
    }

    @ExceptionHandler(value = {ExpiredTokenException.class,InvalidCredentialsException.class})
    public ResponseEntity<ResponseUtil> authException(ExpiredTokenException expiredTokenException){
        return ResponseEntity.status(UNAUTHORIZED).body(
                ResponseUtil.builder()
                        .timeStamp(now())
                        .reason(expiredTokenException.getMessage())
                        .status(UNAUTHORIZED)
                        .statusCode(UNAUTHORIZED.value())
                        .build()
        );
    }

}
