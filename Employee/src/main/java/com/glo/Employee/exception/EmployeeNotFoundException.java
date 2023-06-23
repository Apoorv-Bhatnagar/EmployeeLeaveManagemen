package com.glo.Employee.exception;

public class EmployeeNotFoundException extends RuntimeException{
    private String message;
    public EmployeeNotFoundException(String msge)
    {
        message=msge;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
