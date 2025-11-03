package com.lab.gateway.lab_gateway.infraestructure.service;

import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.apiFactory.LaboratoryFactory;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.ApiClient;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.TypeRefs;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.LaboratoryDto;

@Service
public class LaboratoryService {
    private final ApiClient api;
    private final LaboratoryFactory routes;

    public LaboratoryService(LaboratoryFactory routes, ApiClient api) {
        this.api = api;
        this.routes = routes;
    }

    public ResultDto<LaboratoryDto> createLaboratory(LaboratoryDto dto) {
        try {
            return api.invokeBlocking(
                HttpMethod.POST,
                routes.createLaboratory,
                null, null, null,
                dto,
                TypeRefs.resultOf(LaboratoryDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error creating laboratory: " + e.getMessage());
        }
    }

    public ResultDto<LaboratoryDto> updateLaboratory(Long id, LaboratoryDto dto) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.POST,
                routes.updateLaboratory,
                params, null, null,
                dto,
                TypeRefs.resultOf(LaboratoryDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error updating laboratory: " + e.getMessage());
        }
    }

    public ResultDto<String> deleteLaboratory(Long id) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.DELETE,
                routes.deleteLaboratory,
                params, null, null,
                null,
                TypeRefs.resultOf(String.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error deleting laboratory: " + e.getMessage());
        }
    }

    public ResultDto<LaboratoryDto[]> getAllLaboratories() {
        try {
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getAllLaboratories,
                null, null, null,
                null,
                TypeRefs.resultOf(LaboratoryDto[].class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching laboratories: " + e.getMessage());
        }
    }

    public ResultDto<LaboratoryDto> getLaboratoryById(Long id) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getLaboratoryById,
                params, null, null,
                null,
                TypeRefs.resultOf(LaboratoryDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching laboratory: " + e.getMessage());
        }
    }

    public ResultDto<LaboratoryDto[]> getLaboratoriesBySpecialization(String specialization) {
        try {
            Map<String, Object> params = Map.of("specialization", specialization);
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getLaboratoriesBySpecialization,
                params, null, null,
                null,
                TypeRefs.resultOf(LaboratoryDto[].class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching laboratories by specialization: " + e.getMessage());
        }
    }
}