package com.codecool.shop.service;
import com.codecool.shop.model.dto.CheckOutDto;

import javax.validation.*;
import javax.validation.constraints.NotNull;


public class VerificationService {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();


    public boolean validateCheckout(CheckOutDto checkOutDto) {
        if (validator.validate(checkOutDto).size() == 0) {
            System.out.println("EMPTY");
            return true;
        }
        System.out.println("NOT EMPTY");

    public boolean validateEmail(String email) {
        validator.validate(email);

        return false;
    }
}