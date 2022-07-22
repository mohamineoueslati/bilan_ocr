package com.amenbank.bilan_ocr.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {
    @NotBlank
    protected String username;
    @NotBlank
    protected String firstName;
    @NotBlank
    protected String lastName;
    @NotBlank
    protected String role;
}
