package com.socialbooks.socialbooks.handler;

import com.socialbooks.socialbooks.services.exceptions.LivroNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<Void> handleLivroNaoEncontradoException(LivroNaoEncontradoException e,
                                                                  HttpServletRequest request){
        return ResponseEntity.notFound().build();

    }
}
