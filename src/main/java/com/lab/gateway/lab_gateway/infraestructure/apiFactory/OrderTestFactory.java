package com.lab.gateway.lab_gateway.infraestructure.apiFactory;

import org.springframework.stereotype.Component;

import com.lab.gateway.lab_gateway.infraestructure.configuration.ApiConfiguration;

@Component
public class OrderTestFactory {

    private final String baseUrl;

    public final String createOrderTest;
    public final String updateOrderTest;
    public final String deleteOrderTest;
    public final String getAllOrderTests;
    public final String getOrderTestById;
    public final String getOrderTestsByOrderId;

    public OrderTestFactory(ApiConfiguration apiConfig) {
        this.baseUrl = apiConfig.getApiLaboratory() + "/api/laboratory/order-test/";
        this.createOrderTest = baseUrl + "create";
        this.updateOrderTest = baseUrl + "update/{id}";
        this.deleteOrderTest = baseUrl + "delete/{id}";
        this.getAllOrderTests = baseUrl + "all";
        this.getOrderTestById = baseUrl + "{id}";
        this.getOrderTestsByOrderId = baseUrl + "by-order/{orderId}";
    }
}