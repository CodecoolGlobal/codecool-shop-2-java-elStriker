package com.codecool.shop.service;

import com.codecool.shop.model.dto.CheckOutDto;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VerificationServiceTest {

    private VerificationService verificationService = new VerificationService();

    @Test
    public void validateCheckOut_validInput_returnTrue() {
        assertTrue(verificationService.validateCheckout(new CheckOutDto("grtgdd", "vgref@fgrdf.com", "545345", "gdgrdg", "ghfhtf")));
    }

    @Test
    public void validateCheckOut_inValidInput_returnFalse() {
        assertFalse(verificationService.validateCheckout(new CheckOutDto("grtgdd", "vfgrddfg", "545345", "gdgrdg", "ghfhtf")));
    }
}
