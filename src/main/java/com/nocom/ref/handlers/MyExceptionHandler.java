package com.nocom.ref.handlers;

import com.nocom.ref.exceptions.DocumentNotFoundException;
import com.nocom.ref.exceptions.DocumentNotUploadedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(DocumentNotFoundException.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
    @ExceptionHandler(DocumentNotUploadedException.class)
    public void springHandleNotUploaded(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}


