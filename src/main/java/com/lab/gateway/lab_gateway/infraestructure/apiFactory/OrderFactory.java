package com.lab.gateway.lab_gateway.infraestructure.apiFactory;

import org.springframework.stereotype.Component;

import com.lab.gateway.lab_gateway.infraestructure.configuration.ApiConfiguration;

@Component
public class OrderFactory {

    private final String baseUrl;

    public final String createOrder;
    public final String updateOrder;
    public final String deleteOrder;
    public final String getAllOrders;
    public final String getOrderById;
    public final String getOrdersByPatientId;

    public OrderFactory(ApiConfiguration apiConfig) {
        this.baseUrl = apiConfig.getApiLaboratory() + "/api/laboratory/order/";
        this.createOrder = baseUrl + "create";
        this.updateOrder = baseUrl + "update/{id}";
        this.deleteOrder = baseUrl + "delete/{id}";
        this.getAllOrders = baseUrl + "all";
        this.getOrderById = baseUrl + "{id}";
        this.getOrdersByPatientId = baseUrl + "by-patient/{patientId}";
      
    }
}