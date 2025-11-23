package com.lab.gateway.lab_gateway.infraestructure.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiConfiguration {
    @Value("${enviroment.api-laboratory}")
    private String apiLaboratory;

    @Value("${enviroment.api-authentication}")
    private String apiAuthentication;

    @Value("${enviroment.api-test-result}")
    private String apiTestResult;
    
    public String getApiLaboratory() {
        return apiLaboratory;
    }

    public String getApiAuthentication() {
        return apiAuthentication;
    }
    public String getApiTestResult() {
        return apiTestResult;
    }
}
