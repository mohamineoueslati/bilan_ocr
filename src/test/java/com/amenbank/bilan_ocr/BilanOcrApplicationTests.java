package com.amenbank.bilan_ocr;

import com.amenbank.bilan_ocr.entity.User;
import com.amenbank.bilan_ocr.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BilanOcrApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void test() {
        var user = new User();
        user.setUsername("moh");
        user.setPassword("moh");
        user.setFirstName("moh");
        user.setLastName("moh");

        userRepository.save(user);
    }
}
