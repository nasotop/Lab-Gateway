package com.lab.gateway.lab_gateway.infraestructure.apiFactory;

import org.springframework.stereotype.Component;

import com.lab.gateway.lab_gateway.infraestructure.configuration.ApiConfiguration;

@Component
public class ParametersFactory {

    private final String baseUrl;


    public final String getSpecializations;
    public final String getTestStatus;
    public final String getPriorities;
    public final String getOrderStatus;

    public ParametersFactory(ApiConfiguration apiConfig) {
        this.baseUrl = apiConfig.getApiLaboratory() + "/api/laboratory/parameter/";
        this.getSpecializations = baseUrl + "specializations";
        this.getTestStatus = baseUrl + "test-status";   
        this.getPriorities = baseUrl + "priorities";
        this.getOrderStatus = baseUrl + "order-status";
    }
}