package com.codecool.shop.model.dto;

import jdk.jfr.Name;

import javax.validation.constraints.*;

public class CheckOutDto {
    @NotNull
    @Size(min = 2, message = "Name must be at least 2 character long.")
    private String name;
    @Email(message = "Email should be valid")
    String email;
   // @Pattern(regexp = "\\d{12}$")
    @NotNull
    @Pattern(regexp = "\\s*\\d*[1-9]+",message="must be a number")
    private String phoneNumber;
    @NotBlank
    private String billingAddress;
    @NotBlank
    private String shippingAddress;

    public CheckOutDto(String name, String email, String phoneNumber, String billingAddress, String shippingAddress) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }
}
