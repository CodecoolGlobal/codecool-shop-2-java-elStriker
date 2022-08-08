package com.codecool.shop.service;
import javax.validation.*;

public class VerificationService {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();

    public boolean validateEmail(String email) {
        validator.validate(email);

    }
}
