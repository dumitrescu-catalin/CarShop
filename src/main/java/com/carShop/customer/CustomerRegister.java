package com.carShop.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.PrimitiveIterator;
import java.util.Random;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegister {

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    private int phoneNumber;




}
