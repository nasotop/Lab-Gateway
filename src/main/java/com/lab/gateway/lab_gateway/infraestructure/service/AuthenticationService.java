package com.lab.gateway.lab_gateway.infraestructure.service;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.apiFactory.AuthenticationFactory;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.ApiClient;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.TypeRefs;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.UserDto;


import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final ApiClient api;
    private final AuthenticationFactory routes; // expone rutas absolutas (String login, etc.)

    public AuthenticationService(AuthenticationFactory routes, ApiClient api) {
        this.api = api;
        this.routes = routes;
    }

    public ResultDto<UserDto> login(String email, String password) {

        try {
            Map<String, Object> params = Map.of("email", email, "password", password);
            return api.invokeBlocking(
                    HttpMethod.GET,
                    routes.login,
                    null,
                    params,
                    null,
                    null,
                    TypeRefs.resultOf(UserDto.class));
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

}
