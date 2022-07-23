package com.amenbank.bilan_ocr;

import com.amenbank.bilan_ocr.dto.UserResponse;
import com.amenbank.bilan_ocr.entity.Role;
import com.amenbank.bilan_ocr.entity.User;
import com.amenbank.bilan_ocr.repository.RoleRepository;
import com.amenbank.bilan_ocr.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class BilanOcrApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void fetchUsers() {
        var user = userRepository.findByUsername("moh");
        var modelMapper = new ModelMapper();
        var userDto = modelMapper.map(user, UserResponse.class);

        Assertions.assertEquals("Admin", userDto.getRole());
    }
}
