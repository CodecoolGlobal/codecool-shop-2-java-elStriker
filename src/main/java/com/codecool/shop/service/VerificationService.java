package com.codecool.shop.service;
import com.codecool.shop.model.dto.CheckOutDto;

import javax.validation.*;

public class VerificationService {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();


    public boolean validateCheckout(CheckOutDto checkOutDto) {
        return validator.validate(checkOutDto).size() == 0;
    }
}