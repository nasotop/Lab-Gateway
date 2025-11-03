package com.lab.gateway.lab_gateway.infraestructure.service;

import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.apiFactory.AuthenticationFactory;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.ApiClient;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.TypeRefs;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.UserDto;

@Service
public class UserService {
    private final ApiClient api;
    private final AuthenticationFactory routes; // expone rutas absolutas (String login, etc.)

    public UserService(AuthenticationFactory routes, ApiClient api) {
        this.api = api;
        this.routes = routes;
    }

    public ResultDto<UserDto> updateUser(UserDto userDto) {

        try {
            Map<String, Object> params = Map.of("id", userDto.getId());
            return api.invokeBlocking(
                    HttpMethod.POST,
                    routes.updateUser,

                    params,
                    null,
                    null,
                    userDto,
                    TypeRefs.resultOf(UserDto.class));
        } catch (Exception e) {
            return ResultDto.fail("Error fetching user: " + e.getMessage());
        }
    }

    public ResultDto<String> deleteUser(Long id) {

        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                    HttpMethod.DELETE,
                    routes.deleteUser,
                    params,
                    null,
                    null,
                    null,
                    TypeRefs.resultOf(String.class));
        } catch (Exception e) {
            return ResultDto.fail("Error fetching user: " + e.getMessage());
        }
    }

    public ResultDto<UserDto[]> getAllUsers() {

        try {
            return api.invokeBlocking(
                    HttpMethod.GET,
                    routes.getAllUsers,
                    null,
                    null,
                    null,
                    null,
                    TypeRefs.resultOf(UserDto[].class));
        } catch (Exception e) {
            return ResultDto.fail("Error fetching user: " + e.getMessage());
        }

    }

    public ResultDto<UserDto> getUserById(Long id) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                    HttpMethod.GET,
                    routes.getUserById,
                    params,
                    null,
                    null,
                    null,
                    TypeRefs.resultOf(UserDto.class));
        } catch (Exception e) {
            return ResultDto.fail("Error fetching user: " + e.getMessage());
        }
    }
}
