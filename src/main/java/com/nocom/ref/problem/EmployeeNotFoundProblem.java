package com.nocom.ref.problem;

import java.net.URI;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class EmployeeNotFoundProblem extends AbstractThrowableProblem {

    private static final URI TYPE
            = URI.create("https://example.org/not-found");

    public EmployeeNotFoundProblem(Long employeeId) {
        super(
                TYPE,
                "Not found",
                Status.NOT_FOUND,
                String.format("Task '%s' not found", employeeId));
    }

}