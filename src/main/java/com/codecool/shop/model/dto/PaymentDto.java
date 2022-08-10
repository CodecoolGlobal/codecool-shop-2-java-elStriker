package com.codecool.shop.model.dto;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.*;

public class PaymentDto {
    @NotEmpty
    @CreditCardNumber
    private long ccnumber;
    @NotBlank
    private String ccexp;
    @NotBlank
    private int cvc;
    @NotBlank
    private String name;

    public PaymentDto(long ccnumber, String ccexp, int cvc, String name) {
        this.ccnumber = ccnumber;
        this.ccexp = ccexp;
        this.cvc = cvc;
        this.name = name;
    }

    public long getCcnumber() {
        return ccnumber;
    }

    public void setCcnumber(int ccnumber) {
        this.ccnumber = ccnumber;
    }

    public String getCcexp() {
        return ccexp;
    }

    public void setCcexp(String ccexp) {
        this.ccexp = ccexp;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
