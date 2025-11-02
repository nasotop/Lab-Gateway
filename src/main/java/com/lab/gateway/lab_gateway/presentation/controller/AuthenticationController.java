package com.lab.gateway.lab_gateway.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.service.AuthtenticationService;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.UserDto;

@RestController
@RequestMapping("api/gateway/authentication")
@CrossOrigin(origins = "*")
public class AuthenticationController {
    @Autowired
    private AuthtenticationService authService;

    @GetMapping("/login")
    public ResultDto<UserDto> login(@RequestParam String email, @RequestParam String password) {
        return authService.login(email, password);
    }
}
