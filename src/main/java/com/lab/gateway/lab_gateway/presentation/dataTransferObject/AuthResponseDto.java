package com.lab.gateway.lab_gateway.presentation.dataTransferObject;

public class AuthResponseDto {
    public String token;
    public UserDto user;

    public AuthResponseDto(String token, UserDto user) {
        this.token = token;
        this.user = user;
    }
}
