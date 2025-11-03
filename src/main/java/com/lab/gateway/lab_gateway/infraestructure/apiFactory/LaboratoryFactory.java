package com.lab.gateway.lab_gateway.infraestructure.apiFactory;


import org.springframework.stereotype.Component;

import com.lab.gateway.lab_gateway.infraestructure.configuration.ApiConfiguration;
@Component
public class LaboratoryFactory {
     private final String baseUrl;

    public final String createLaboratory;
    public final String updateLaboratory;
    public final String deleteLaboratory;
    public final String getAllLaboratories;
    public final String getLaboratoryById;
    public final String getLaboratoriesBySpecialization;

    public LaboratoryFactory(ApiConfiguration apiConfig) {
        this.baseUrl = apiConfig.getApiLaboratory() + "/api/laboratory/";
        this.createLaboratory = baseUrl + "create";
        this.updateLaboratory = baseUrl + "update/{id}";
        this.deleteLaboratory = baseUrl + "delete/{id}";
        this.getAllLaboratories = baseUrl + "get-all";
        this.getLaboratoryById = baseUrl + "get-by-id/{id}";
        this.getLaboratoriesBySpecialization = baseUrl + "get-by-specialization/{specialization}";
    }

}
