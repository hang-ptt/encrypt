package com.example.encrypt.controller;

import com.example.encrypt.domain.User;
import com.example.encrypt.dto.UserDTO;
import com.example.encrypt.dto.UserRequestDTO;
import com.example.encrypt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User findbyId(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    public User findUserByPhoneNumberAndRegion(@RequestBody UserDTO userDTO) {
        return userService.findByPhoneNumberAndRegion(userDTO);
    }

    @PostMapping("/user/create")
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/user/get-all")
    public List<UserRequestDTO> getAll(@RequestBody UserDTO userDTO) {
        return userService.findbyNative(userDTO);
    }
}
