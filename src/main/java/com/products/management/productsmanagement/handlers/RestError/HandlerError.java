package com.products.management.productsmanagement.handlers.RestError;

public class HandlerError extends RuntimeException {

    private CustomError customError;

    public CustomError getCustomError() {
        return this.customError;
    }

    public void setCustomError(CustomError customError) {
        this.customError = customError;
    }

    public HandlerError(CustomError customError){
        super();
        this.customError = customError;
    }
}