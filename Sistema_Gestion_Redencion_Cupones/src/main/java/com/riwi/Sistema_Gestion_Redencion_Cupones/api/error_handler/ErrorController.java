package com.riwi.Sistema_Gestion_Redencion_Cupones.api.error_handler;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.errors.ErrorResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.errors.ErrorsListResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.utils.exceptions.BadRequestException;
import com.riwi.Sistema_Gestion_Redencion_Cupones.utils.exceptions.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(MetaDataAccessException.class)
    public ErrorsListResponse handlerBadRequest(MethodArgumentNotValidException exception){
        List<Map<String,String>> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(error->{
            Map<String ,String > errorResponse = new HashMap<>();
            errorResponse.put("Error:" , error.getDefaultMessage());
            errorResponse.put("Field:" , error.getField());

            errors.add(errorResponse);

        });
            return ErrorsListResponse.builder().code(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.name()).errors(errors).build();
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ErrorResponse idNotFoundException(IdNotFoundException exception){
        Map<String, String > error = new HashMap<>();

        error.put("Error:" ,"ID not found");
        error.put("Entity:" , exception.getMessage());

        return ErrorResponse.builder().code(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.name()).error(error).build();
    }

    @ExceptionHandler(BadRequestException.class)
    public ErrorResponse handlerRequestError(BadRequestException exception){
        Map<String ,String > errorResponse = new HashMap<>();
        errorResponse.put("Error:", exception.getMessage());

        return ErrorResponse.builder().code(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.name()).error(errorResponse).build();
    }
}
