package com.carShop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.CONFLICT)
public class UserAlreadyExistInDB extends RuntimeException{

    public UserAlreadyExistInDB (String message) {
        super(message);
    }

}
