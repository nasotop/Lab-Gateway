package com.lab.gateway.lab_gateway.infraestructure.service;

import java.util.Map;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.apiFactory.OrderTestFactory;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.ApiClient;
import com.lab.gateway.lab_gateway.infraestructure.service.apiService.TypeRefs;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.OrderTestDto;

@Service
public class OrderTestService {

    private final ApiClient api;
    private final OrderTestFactory routes;

    public OrderTestService(OrderTestFactory routes, ApiClient api) {
        this.api = api;
        this.routes = routes;
    }

    public ResultDto<OrderTestDto> createOrderTest(OrderTestDto dto) {
        try {
            return api.invokeBlocking(
                HttpMethod.POST,
                routes.createOrderTest,
                null, null, null,
                dto,
                TypeRefs.resultOf(OrderTestDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error creating order test: " + e.getMessage());
        }
    }

    public ResultDto<OrderTestDto> updateOrderTest(Long id, OrderTestDto dto) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.POST,
                routes.updateOrderTest,
                params, null, null,
                dto,
                TypeRefs.resultOf(OrderTestDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error updating order test: " + e.getMessage());
        }
    }

    public ResultDto<String> deleteOrderTest(Long id) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.DELETE,
                routes.deleteOrderTest,
                params, null, null,
                null,
                TypeRefs.resultOf(String.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error deleting order test: " + e.getMessage());
        }
    }

    public ResultDto<OrderTestDto[]> getAllOrderTests() {
        try {
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getAllOrderTests,
                null, null, null,
                null,
                TypeRefs.resultOf(OrderTestDto[].class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching order tests: " + e.getMessage());
        }
    }

    public ResultDto<OrderTestDto> getOrderTestById(Long id) {
        try {
            Map<String, Object> params = Map.of("id", id);
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getOrderTestById,
                params, null, null,
                null,
                TypeRefs.resultOf(OrderTestDto.class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching order test: " + e.getMessage());
        }
    }

    public ResultDto<OrderTestDto[]> getOrderTestsByOrderId(Long orderId) {
        try {
            Map<String, Object> params = Map.of("orderId", orderId);
            return api.invokeBlocking(
                HttpMethod.GET,
                routes.getOrderTestsByOrderId,
                params, null, null,
                null,
                TypeRefs.resultOf(OrderTestDto[].class)
            );
        } catch (Exception e) {
            return ResultDto.fail("Error fetching tests by order: " + e.getMessage());
        }
    }

}
