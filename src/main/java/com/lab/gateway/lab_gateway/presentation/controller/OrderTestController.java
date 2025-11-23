package com.lab.gateway.lab_gateway.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.service.OrderTestService;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.OrderTestDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order-test")
public class OrderTestController {
    @Autowired
    private OrderTestService orderTestService;

    @PostMapping("create-order-test")
    public ResultDto<OrderTestDto> create(@Valid @RequestBody OrderTestDto dto) {
        return orderTestService.createOrderTest(dto);
    }

    @PostMapping("update-order-test/{id}")
    public ResultDto<OrderTestDto> update(@PathVariable Long id, @Valid @RequestBody OrderTestDto dto) {
        return orderTestService.updateOrderTest(id, dto);
    }

    @DeleteMapping("delete-order-test/{id}")
    public ResultDto<String> delete(@PathVariable Long id) {
        return orderTestService.deleteOrderTest(id);
    }

    @GetMapping("get-all-order-tests")
    public ResultDto<OrderTestDto[]> getAll() {
        return orderTestService.getAllOrderTests();
    }

    @GetMapping("get-order-test-by-id/{id}")
    public ResultDto<OrderTestDto> getById(@PathVariable Long id) {
        return orderTestService.getOrderTestById(id);
    }

    @GetMapping("get-order-tests-by-order-id/{orderId}")
    public ResultDto<OrderTestDto[]> getByOrderId(@PathVariable Long orderId) {
        return orderTestService.getOrderTestsByOrderId(orderId);
    }

 
}
