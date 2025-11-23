package com.lab.gateway.lab_gateway.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab.gateway.lab_gateway.configuration.JwtService;
import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.service.AuthenticationService;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.AuthResponseDto;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.CredentialsDto;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.UserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("authentication")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authService;

    @PostMapping("/login")
    public ResultDto<AuthResponseDto> login(@Valid @RequestBody CredentialsDto credentials) {
        return authService.login(credentials.getEmail(), credentials.getPassword());
    }

    @PostMapping("/register")
    public ResultDto<UserDto> register(@Valid @RequestBody UserDto userDto) {
        return authService.register(userDto);
    }

    @PostMapping("/recovery")
    public ResultDto<String> recovery(@RequestParam String email) {
        return authService.recovery(email);
    }

    @PostMapping("/validate")
    public ResultDto<UserDto> validate(@RequestHeader("Authorization") String header) {
        String token = header != null && header.startsWith("Bearer ")
                ? header.substring(7)
                : null;

        return authService.validateToken(token);
    }
}
