package com.lab.gateway.lab_gateway.infraestructure.apiFactory;

import org.springframework.stereotype.Component;

import com.lab.gateway.lab_gateway.infraestructure.configuration.ApiConfiguration;
@Component
public class TestResulFactory {

    private final String baseUrl;

    public final String createTestResult;
    public final String updateTestResult;
    public final String deleteTestResult;
    public final String getAllTestResults;
    public final String getTestResultById;
    public final String getByOrderTestId;
    public final String getByStatus;
    public final String getStatuses;

    public TestResulFactory(ApiConfiguration apiConfig) {

        this.baseUrl = apiConfig.getApiTestResult() + "/api/test/results";
        this.createTestResult = baseUrl;
        this.getAllTestResults = baseUrl;
        this.getTestResultById = baseUrl + "/{id}";
        this.updateTestResult = baseUrl + "/{id}";
        this.deleteTestResult = baseUrl + "/{id}";
        this.getByOrderTestId = baseUrl + "/order-test/{id}";
        this.getByStatus = baseUrl + "/status/{status}";
        this.getStatuses = baseUrl + "/status";
    }
}
