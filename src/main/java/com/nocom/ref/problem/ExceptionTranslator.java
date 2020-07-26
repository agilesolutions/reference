package com.nocom.ref.problem;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;

import java.net.URI;

/**
 * Controller advice to translate the server side exceptions to client-friendly
 * json structures. The error response follows RFC7807 - Problem Details for
 * HTTP APIs (https://tools.ietf.org/html/rfc7807).
 */
@ControllerAdvice
public class ExceptionTranslator implements ProblemHandling {


    @Value("${spring.service.name}")

    private String applicationName;

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Problem> handleBadRequestAlertException(EmployeeNotFoundException ex,
                                                                  NativeWebRequest request) {

        Problem problem = Problem.builder()
                .withType(URI.create("https://example.org/out-of-stock"))
                .withTitle("Customer not found")
                .withStatus(Status.NOT_FOUND)
                .withDetail("Employee B00027Y5QG is not available")
                .with("employee", ex.getDetail())
                .build();

        return create(ex, problem, request);
    }
}
