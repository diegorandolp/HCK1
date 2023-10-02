package com.example.demo.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Grade not found")
public class GradeNotFound extends RuntimeException {
    public GradeNotFound(String msg)
    {
        super(msg);
    }

}