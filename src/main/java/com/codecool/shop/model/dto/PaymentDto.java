package com.codecool.shop.model.dto;

import javax.validation.constraints.NotEmpty;

public class PaymentDto {
    @NotEmpty
    private int ccnumber;
    private String ccexp;
    private int cvc;
    private String name;

    public PaymentDto(int ccnumber, String ccexp, int cvc, String name) {
        this.ccnumber = ccnumber;
        this.ccexp = ccexp;
        this.cvc = cvc;
        this.name = name;
    }

    public int getCcnumber() {
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
