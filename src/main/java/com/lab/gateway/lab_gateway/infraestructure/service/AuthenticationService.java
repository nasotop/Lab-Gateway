package com.lab.gateway.lab_gateway.infraestructure.service;

import com.lab.gateway.lab_gateway.configuration.JwtService;
import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.apiFactory.AuthenticationFactory;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.ApiClient;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.TypeRefs;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.AuthResponseDto;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.UserDto;


import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final ApiClient api;
    private final AuthenticationFactory routes; 
    private final JwtService jwtService;

    public AuthenticationService(AuthenticationFactory routes, ApiClient api, JwtService jwtService) {
        this.jwtService = jwtService;
        this.api = api;
        this.routes = routes;
    }

public ResultDto<AuthResponseDto> login(String email, String password) {
    try {
        Map<String, Object> params = Map.of("email", email, "password", password);

        ResultDto<UserDto> externalResult = api.invokeBlocking(
                HttpMethod.GET,
                routes.login,
                null,
                params,
                null,
                null,
                TypeRefs.resultOf(UserDto.class)
        );

        if (!externalResult.isSuccess() || externalResult.getData() == null) {
            return ResultDto.fail(externalResult.getErrorMessage() != null ? externalResult.getErrorMessage() : "Credenciales inválidas");
        }

        UserDto user = externalResult.getData();

        String token = jwtService.generateToken(user.getEmail(), user.getId(), user.getRole());

        AuthResponseDto response = new AuthResponseDto(token, user);

        return ResultDto.ok(response);

    } catch (Exception e) {
        return ResultDto.fail("Error: " + e.getMessage());
    }
}

    public ResultDto<UserDto> register(UserDto userDto) {

        try {
            return api.invokeBlocking(
                    HttpMethod.POST,
                    routes.register,
                    null,
                    null,
                    null,
                    userDto,
                    TypeRefs.resultOf(UserDto.class));
        } catch (Exception e) {
            return ResultDto.fail("Error: " + e.getMessage());
        }
    }

    public ResultDto<String> recovery(String email) {

        try {
            Map<String, Object> params = Map.of("email", email);

            return api.invokeBlocking(
                    HttpMethod.POST,
                    routes.register,
                    params,
                    null,
                    null,
                    null,
                    TypeRefs.resultOf(String.class));
        } catch (Exception e) {
            return ResultDto.fail("Error: " + e.getMessage());
        }
    }

    public ResultDto<UserDto> validateToken(String token) {
    try {
        if (token == null || token.isBlank()) {
            return ResultDto.fail("Token ausente");
        }

        if (!jwtService.isTokenValid(token)) {
            return ResultDto.fail("Token inválido");
        }

        String email = jwtService.extractUsername(token);
        Long userId = jwtService.extractUserId(token);
        String role = jwtService.extractRole(token);

        if (email == null || userId == null || role == null) {
            return ResultDto.fail("Token incompleto");
        }

        UserDto user = new UserDto();
        user.setId(userId);
        user.setEmail(email);
        user.setRole(role);

        return ResultDto.ok(user);

    } catch (Exception e) {
        return ResultDto.fail("Error validando token: " + e.getMessage());
    }
}

}
