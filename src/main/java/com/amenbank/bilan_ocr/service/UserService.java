package com.amenbank.bilan_ocr.service;

import com.amenbank.bilan_ocr.entity.User;
import com.amenbank.bilan_ocr.exception.DuplicatedEntityException;
import com.amenbank.bilan_ocr.exception.InvalidPasswordException;
import com.amenbank.bilan_ocr.exception.NotFoundException;
import com.amenbank.bilan_ocr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            if (existsByUsername(user.getUsername()))
                throw new DuplicatedEntityException("Found another user with username " + user.getUsername());
            if (user.getPassword().trim().isBlank()) throw new InvalidPasswordException("Password not valid");
        } else {
            var currentUser = findById(user.getId());
            if (!currentUser.getUsername().equals(user.getUsername())) {
                if (existsByUsername(user.getUsername()))
                    throw new DuplicatedEntityException("Found another user with username " + user.getUsername());
            }
            if (user.getPassword() != null && !user.getPassword().trim().isBlank()) {
                user.setPassword(currentUser.getPassword());
            }
        }

        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User with username " + username + " not found"));
    }
}
