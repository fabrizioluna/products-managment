package com.products.management.productsmanagement.handlers.RestError;

// import lombok.Getter;
import lombok.NoArgsConstructor;
// import lombok.Setter;

@NoArgsConstructor
public class CustomError {

    private int code;
    private String message;
    private String cause;

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCause() {
        return this.cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public CustomError(int code, String message, String cause) {
        this.code = code;
        this.message = message;
        this.cause = cause;
    }
}