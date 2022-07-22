package com.amenbank.bilan_ocr.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserRequest extends UserDto {
    private String password;
}
