package com.lab.gateway.lab_gateway.infraestructure.apiFactory;

import org.springframework.stereotype.Component;

import com.lab.gateway.lab_gateway.infraestructure.configuration.ApiConfiguration;

@Component
public class AuthenticationFactory {

    private final String baseUrl;

    public final String login;
    public final String register;
    public final String updateUser;
    public final String deleteUser;
    public final String getAllUsers;
    public final String getUserById;

    public AuthenticationFactory(ApiConfiguration apiConfig) {
        this.baseUrl = apiConfig.getApiAuthentication() + "/api/user/";
        this.login = baseUrl + "login";
        this.register = baseUrl + "register";
        this.updateUser = baseUrl + "update/{id}";
        this.deleteUser = baseUrl + "delete/{id}";
        this.getAllUsers = baseUrl + "get-all-users";
        this.getUserById = baseUrl + "get-user-by-id/{id}";
    }
}
