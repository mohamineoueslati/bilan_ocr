package com.amenbank.bilan_ocr.controller;

import com.amenbank.bilan_ocr.dto.UserRequest;
import com.amenbank.bilan_ocr.dto.UserResponse;
import com.amenbank.bilan_ocr.entity.Role;
import com.amenbank.bilan_ocr.entity.User;
import com.amenbank.bilan_ocr.service.IRoleService;
import com.amenbank.bilan_ocr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;
    private final IRoleService roleService;

    @Autowired
    public UserController(IUserService userService, IRoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return userService.findAll().stream().map(UserResponse::new).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public UserResponse getUser(@PathVariable Integer id) {
        return new UserResponse(userService.findById(id));
    }

    @PostMapping
    public UserResponse saveUser(@RequestBody UserRequest userRequest) {
        var role = fetchRole(userRequest.getRole());
        var user = new User(userRequest);
        user.setCreatedAt(new Date());
        user.setRole(role);

        return new UserResponse(userService.save(user));
    }

    @PutMapping("{id}")
    public UserResponse updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest) {
        var role = fetchRole(userRequest.getRole());
        var user = new User(userRequest);
        user.setId(id);
        user.setRole(role);

        return new UserResponse(userService.save(user));
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    private Role fetchRole(String role) {
        return roleService.findByRole(role);
    }
}
