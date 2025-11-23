package com.lab.gateway.lab_gateway.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.service.UserService;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.UserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResultDto<UserDto> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public ResultDto<UserDto[]> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get-by-role/{role}")
    public ResultDto<UserDto[]> getUserByRole(@PathVariable String role) {
        return userService.getUsersByRole(role);
    }

    @PostMapping("/update")
    public ResultDto<UserDto> updateUser(@Valid @RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResultDto<String> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}
