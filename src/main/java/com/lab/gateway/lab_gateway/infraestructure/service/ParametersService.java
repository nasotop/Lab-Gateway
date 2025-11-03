package com.lab.gateway.lab_gateway.infraestructure.service;

import java.util.Map;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.apiFactory.ParametersFactory;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.ApiClient;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.TypeRefs;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.ParameterDto;

@Service
public class ParametersService {

    private final ApiClient api;
    private final ParametersFactory routes;

    public ParametersService(ParametersFactory routes, ApiClient api) {
        this.api = api;
        this.routes = routes;
    }

  
    public ResultDto<ParameterDto[]> getOrderStatus() {
        try {
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getOrderStatus,
                null, null, null,
                null,
                TypeRefs.resultOf(ParameterDto[].class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching parameters: " + e.getMessage());
        }
    }

    public ResultDto<ParameterDto[]> getPriorities() {
        try {
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getPriorities,
                null, null, null,
                null,
                TypeRefs.resultOf(ParameterDto[].class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching parameters: " + e.getMessage());
        }
    }
    public ResultDto<ParameterDto[]> getSpecializations() {
        try {
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getSpecializations,
                null, null, null,
                null,
                TypeRefs.resultOf(ParameterDto[].class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching parameters: " + e.getMessage());
        }
    }
 public ResultDto<ParameterDto[]> getTestStatus() {
        try {
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getTestStatus,
                null, null, null,
                null,
                TypeRefs.resultOf(ParameterDto[].class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching parameters: " + e.getMessage());
        }
    }
}
