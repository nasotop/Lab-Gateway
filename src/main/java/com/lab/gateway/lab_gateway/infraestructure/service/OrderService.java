package com.lab.gateway.lab_gateway.infraestructure.service;

import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.apiFactory.OrderFactory;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.ApiClient;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.TypeRefs;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.OrderDto;

@Service
public class OrderService {

    private final ApiClient api;
    private final OrderFactory routes;

    public OrderService(OrderFactory routes, ApiClient api) {
        this.api = api;
        this.routes = routes;
    }

    public ResultDto<OrderDto> createOrder(OrderDto dto) {
        try {
            return api.invokeBlocking(
                HttpMethod.POST,
                routes.createOrder,
                null, null, null,
                dto,
                TypeRefs.resultOf(OrderDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error creating order: " + e.getMessage());
        }
    }

    public ResultDto<OrderDto> updateOrder(Long id, OrderDto dto) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.POST,
                routes.updateOrder,
                params, null, null,
                dto,
                TypeRefs.resultOf(OrderDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error updating order: " + e.getMessage());
        }
    }

    public ResultDto<String> deleteOrder(Long id) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.DELETE,
                routes.deleteOrder,
                params, null, null,
                null,
                TypeRefs.resultOf(String.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error deleting order: " + e.getMessage());
        }
    }

    public ResultDto<OrderDto[]> getAllOrders() {
        try {
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getAllOrders,
                null, null, null,
                null,
                TypeRefs.resultOf(OrderDto[].class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching orders: " + e.getMessage());
        }
    }

    public ResultDto<OrderDto> getOrderById(Long id) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getOrderById,
                params, null, null,
                null,
                TypeRefs.resultOf(OrderDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching order: " + e.getMessage());
        }
    }

    public ResultDto<OrderDto[]> getOrdersByPatientId(Long patientId) {
        try {
            Map<String, Object> params = Map.of("patientId", patientId);
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getOrdersByPatientId,
                params, null, null,
                null,
                TypeRefs.resultOf(OrderDto[].class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching orders by patient: " + e.getMessage());
        }
    }

 

}
