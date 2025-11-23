package com.lab.gateway.lab_gateway.infraestructure.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.apiFactory.TestResulFactory;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.ApiClient;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.TypeRefs;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.TestResultDto;

@Service
public class TestResultService {

    private final ApiClient api;
    private final TestResulFactory routes;

    public TestResultService(TestResulFactory routes, ApiClient api) {
        this.api = api;
        this.routes = routes;
    }

    public ResultDto<TestResultDto> create(TestResultDto dto) {
        try {
            var response = api.invokeBlocking(
                    HttpMethod.POST,
                    routes.createTestResult,
                    null,
                    null,
                    null,
                    dto,
                    TypeRefs.resultOf(TestResultDto.class));

            return response;
        } catch (Exception e) {
            return ResultDto.fail("Error creating test result: " + e.getMessage());
        }
    }

    public ResultDto<TestResultDto> update(Long id, TestResultDto dto) {
        try {
            var response = api.invokeBlocking(
                    HttpMethod.PUT,
                    routes.updateTestResult.replace("{id}", id.toString()),
                    null,
                    null,
                    null,
                    dto,
                    TypeRefs.resultOf(TestResultDto.class));

            return response;
        } catch (Exception e) {
            return ResultDto.fail("Error updating test result: " + e.getMessage());
        }
    }

    public ResultDto<TestResultDto> delete(Long id) {
        try {
            var response = api.invokeBlocking(
                    HttpMethod.DELETE,
                    routes.deleteTestResult.replace("{id}", id.toString()),
                    null,
                    null,
                    null,
                    null,
                    TypeRefs.resultOf(TestResultDto.class));

            return response;
        } catch (Exception e) {
            return ResultDto.fail("Error deleting test result: " + e.getMessage());
        }
    }

    public ResultDto<TestResultDto[]> getAll() {
        try {
            var response = api.invokeBlocking(
                    HttpMethod.GET,
                    routes.getAllTestResults,
                    null,
                    null,
                    null,
                    null,
                    TypeRefs.resultOf(TestResultDto[].class));

            return response;
        } catch (Exception e) {
            return ResultDto.fail("Error fetching test results: " + e.getMessage());
        }
    }

    public ResultDto<TestResultDto> getById(Long id) {
        try {
            var response = api.invokeBlocking(
                    HttpMethod.GET,
                    routes.getTestResultById.replace("{id}", id.toString()),
                    null,
                    null,
                    null,
                    null,
                    TypeRefs.resultOf(TestResultDto.class));

            return response;
        } catch (Exception e) {
            return ResultDto.fail("Error fetching test result: " + e.getMessage());
        }
    }

    public ResultDto<TestResultDto> getByOrderTestId(Long orderTestId) {
        try {
            var response = api.invokeBlocking(
                    HttpMethod.GET,
                    routes.getByOrderTestId.replace("{id}", orderTestId.toString()),
                    null,
                    null,
                    null,
                    null,
                    TypeRefs.resultOf(TestResultDto.class));

            return response;

        } catch (Exception e) {
            return ResultDto.fail("Error fetching test result by orderTestId: " + e.getMessage());
        }
    }

    public ResultDto<TestResultDto[]> getByStatus(String status) {
        try {
            var response = api.invokeBlocking(
                    HttpMethod.GET,
                    routes.getByStatus.replace("{status}", status),
                    null,
                    null,
                    null,
                    null,
                    TypeRefs.resultOf(TestResultDto[].class));

            return response;

        } catch (Exception e) {
            return ResultDto.fail("Error fetching test results by status: " + e.getMessage());
        }
    }

    public ResultDto<String[]> getStatuses() {
        try {
            var response = api.invokeBlocking(
                    HttpMethod.GET,
                    routes.getStatuses,
                    null,
                    null,
                    null,
                    null,
                    TypeRefs.resultOf(String[].class));

            return response;

        } catch (Exception e) {
            return ResultDto.fail("Error fetching test results by status: " + e.getMessage());
        }
    }
}
