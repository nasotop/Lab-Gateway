package com.lab.gateway.lab_gateway.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.service.AuthenticationService;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.CredentialsDto;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.UserDto;

@RestController
@RequestMapping("api/authentication")
@CrossOrigin(origins = "*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authService;

    @GetMapping("/login")
    public ResultDto<UserDto> login(@RequestBody CredentialsDto credentials) {
        return authService.login(credentials.email, credentials.password);
    }

    @PostMapping("/register")
    public ResultDto<UserDto> register(@RequestBody UserDto userDto) {
        return authService.register(userDto);
    }
}
