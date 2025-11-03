package com.lab.gateway.lab_gateway.infraestructure.service;

import java.util.Map;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.apiFactory.PatientFactory;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.ApiClient;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.TypeRefs;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.PatientDto;

@Service
public class PatientService {

    private final ApiClient api;
    private final PatientFactory routes;

    public PatientService(PatientFactory routes, ApiClient api) {
        this.api = api;
        this.routes = routes;
    }

    public ResultDto<PatientDto> createPatient(PatientDto dto) {
        try {
            return api.invokeBlocking(
                HttpMethod.POST,
                routes.createPatient,
                null, null, null,
                dto,
                TypeRefs.resultOf(PatientDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error creating patient: " + e.getMessage());
        }
    }

    public ResultDto<PatientDto> updatePatient(Long id, PatientDto dto) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.POST,
                routes.updatePatient,
                params, null, null,
                dto,
                TypeRefs.resultOf(PatientDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error updating patient: " + e.getMessage());
        }
    }

    public ResultDto<String> deletePatient(Long id) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.DELETE,
                routes.deletePatient,
                params, null, null,
                null,
                TypeRefs.resultOf(String.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error deleting patient: " + e.getMessage());
        }
    }

    public ResultDto<PatientDto[]> getAllPatients() {
        try {
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getAllPatients,
                null, null, null,
                null,
                TypeRefs.resultOf(PatientDto[].class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching patients: " + e.getMessage());
        }
    }

    public ResultDto<PatientDto> getPatientById(Long id) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getPatientById,
                params, null, null,
                null,
                TypeRefs.resultOf(PatientDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching patient: " + e.getMessage());
        }
    }

   
}
