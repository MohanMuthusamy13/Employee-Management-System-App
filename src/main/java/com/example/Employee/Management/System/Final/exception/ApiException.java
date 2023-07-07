package com.example.Employee.Management.System.Final.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ApiException {
    private String message;
    private Throwable throwable;
    private HttpStatus httpStatus;
    private ZonedDateTime zonedDateTime;
}
