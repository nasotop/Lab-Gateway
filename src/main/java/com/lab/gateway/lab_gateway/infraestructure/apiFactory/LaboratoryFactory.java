package com.lab.gateway.lab_gateway.infraestructure.apiFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.lab.gateway.lab_gateway.infraestructure.configuration.ApiConfiguration;

public class LaboratoryFactory {
        @Autowired
    private static  ApiConfiguration apiConfig;
    
    private static final String LABORATORY_API = apiConfig.getApiLaboratory()+"/api/laboratory/";

    public static String CreateLaboratory = LABORATORY_API + "create";
    public static String UpdateLaboratory = LABORATORY_API + "update";
    public static String DeleteLaboratory = LABORATORY_API + "delete";
    public static String GetAllLaboratories = LABORATORY_API + "get-all";
    public static String GetLaboratoryById = LABORATORY_API + "get-by-id";
    public static String GetLaboratoriesBySpecialization = LABORATORY_API + "get-by-specialization";    


}
