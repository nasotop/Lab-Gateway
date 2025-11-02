package com.lab.gateway.lab_gateway.infraestructure.service;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.apiFactory.AuthenticationFactory;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.UserDto;

import java.net.URI;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AuthtenticationService {
    private final AuthenticationFactory routes;
    private final WebClient.Builder webClientBuilder;

    public AuthtenticationService(AuthenticationFactory routes, WebClient.Builder webClientBuilder) {
        this.routes = routes;
        this.webClientBuilder = webClientBuilder;
    }

    public ResultDto<UserDto> login(String email, String password) {
        WebClient web = webClientBuilder.build();

        URI uri = UriComponentsBuilder
                .fromUriString(routes.login) // usa la URL absoluta completa
                .queryParam("email", email)
                .queryParam("password", password)
                .build(true)
                .toUri();

        return web.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ResultDto<UserDto>>() {
                })
                .block();
    }
}
