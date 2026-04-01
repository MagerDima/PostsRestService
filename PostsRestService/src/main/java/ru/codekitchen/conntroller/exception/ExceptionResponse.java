package ru.codekitchen.conntroller.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private final int status;
    private final String message;
    private final LocalDateTime timestemp;

    public ExceptionResponse(int status, String message) {
        this.status = status;
        this.message = message;
        timestemp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestemp() {
        return timestemp;
    }
}
