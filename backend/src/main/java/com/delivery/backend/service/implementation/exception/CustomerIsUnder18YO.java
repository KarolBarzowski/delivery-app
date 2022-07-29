package com.delivery.backend.service.implementation.exception;

public class CustomerIsUnder18YO extends RuntimeException {
    public CustomerIsUnder18YO(String msg){
        super(msg);
    }
}
