package com.lab.gateway.lab_gateway.infraestructure.service;

import java.util.Map;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.apiFactory.TestTypeFactory;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.ApiClient;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.TypeRefs;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.TestTypeDto;

@Service
public class TestTypeService {

    private final ApiClient api;
    private final TestTypeFactory routes;

    public TestTypeService(TestTypeFactory routes, ApiClient api) {
        this.api = api;
        this.routes = routes;
    }

    public ResultDto<TestTypeDto> createTestType(TestTypeDto dto) {
        try {
            return api.invokeBlocking(
                HttpMethod.POST,
                routes.createTestType,
                null, null, null,
                dto,
                TypeRefs.resultOf(TestTypeDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error creating test type: " + e.getMessage());
        }
    }

    public ResultDto<TestTypeDto> updateTestType(Long id, TestTypeDto dto) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.POST,
                routes.updateTestType,
                params, null, null,
                dto,
                TypeRefs.resultOf(TestTypeDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error updating test type: " + e.getMessage());
        }
    }

    public ResultDto<String> deleteTestType(Long id) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.DELETE,
                routes.deleteTestType,
                params, null, null,
                null,
                TypeRefs.resultOf(String.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error deleting test type: " + e.getMessage());
        }
    }

    public ResultDto<TestTypeDto[]> getAllTestTypes() {
        try {
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getAllTestTypes,
                null, null, null,
                null,
                TypeRefs.resultOf(TestTypeDto[].class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching test types: " + e.getMessage());
        }
    }

    public ResultDto<TestTypeDto> getTestTypeById(Long id) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getTestTypeById,
                params, null, null,
                null,
                TypeRefs.resultOf(TestTypeDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching test type: " + e.getMessage());
        }
    }

    public ResultDto<TestTypeDto[]> getTestTypesBySpecialization(String specialization) {
        try {
            Map<String, Object> params = Map.of("specialization", specialization);
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getTestTypesBySpecialization,
                params, null, null,
                null,
                TypeRefs.resultOf(TestTypeDto[].class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching test types by specialization: " + e.getMessage());
        }
    }
}
