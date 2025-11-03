package com.lab.gateway.lab_gateway.infraestructure.apiFactory;

import org.springframework.stereotype.Component;

import com.lab.gateway.lab_gateway.infraestructure.configuration.ApiConfiguration;

@Component
public class PatientFactory {

    private final String baseUrl;

    public final String createPatient;
    public final String updatePatient;
    public final String deletePatient;
    public final String getAllPatients;
    public final String getPatientById;

    public PatientFactory(ApiConfiguration apiConfig) {
        this.baseUrl = apiConfig.getApiLaboratory() + "/api/laboratory/patient/";
        this.createPatient = baseUrl + "create";
        this.updatePatient = baseUrl + "update/{id}";
        this.deletePatient = baseUrl + "delete/{id}";
        this.getAllPatients = baseUrl + "get-all";
        this.getPatientById = baseUrl + "{id}";
 }
}