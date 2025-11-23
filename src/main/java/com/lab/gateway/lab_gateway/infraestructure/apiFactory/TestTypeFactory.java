package com.lab.gateway.lab_gateway.infraestructure.apiFactory;

import org.springframework.stereotype.Component;

import com.lab.gateway.lab_gateway.infraestructure.configuration.ApiConfiguration;

@Component
public class TestTypeFactory {

    private final String baseUrl;

    public final String createTestType;
    public final String updateTestType;
    public final String deleteTestType;
    public final String getAllTestTypes;
    public final String getTestTypeById;
    public final String getTestTypesBySpecialization;

    public TestTypeFactory(ApiConfiguration apiConfig) {
        this.baseUrl = apiConfig.getApiLaboratory() + "/api/laboratory/test-type/";
        this.createTestType = baseUrl + "create";
        this.updateTestType = baseUrl + "update/{id}";
        this.deleteTestType = baseUrl + "delete/{id}";
        this.getAllTestTypes = baseUrl + "all";
        this.getTestTypeById = baseUrl + "{id}";
        this.getTestTypesBySpecialization = baseUrl + "by-specialization/{specialization}";
    }
}