package com.example.demo.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Student not found")
public class AlumnnoNotFound extends RuntimeException {
    public AlumnnoNotFound(String msg)
    {
        super(msg);
    }

}