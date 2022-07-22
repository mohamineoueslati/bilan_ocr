package com.amenbank.bilan_ocr.service;

import com.amenbank.bilan_ocr.entity.User;
import com.amenbank.bilan_ocr.exception.InvalidPasswordException;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Integer id);
    User save(User user) throws InvalidPasswordException;
    void deleteById(Integer id);
    boolean existsByUsername(String username);
    User findByUsername(String username);
}
