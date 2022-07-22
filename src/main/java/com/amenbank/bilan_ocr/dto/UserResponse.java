package com.amenbank.bilan_ocr.dto;

import com.amenbank.bilan_ocr.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserResponse extends UserDto {
    private Integer id;
    private Date createdAt;

    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.createdAt = user.getCreatedAt();
        this.role = user.getRole().getRole();
    }
}
