package com.lab.gateway.lab_gateway.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.service.OrderService;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.OrderDto;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResultDto<OrderDto> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/all")
    public ResultDto<OrderDto[]> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/create")
    public ResultDto<OrderDto> createOrder(@RequestBody OrderDto dto) {
        return orderService.createOrder(dto);
    }

    @PostMapping("/update")
    public ResultDto<OrderDto> updateOrder(@RequestBody OrderDto dto) {
        return orderService.updateOrder(dto.getId(), dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResultDto<String> deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }

    @GetMapping("/by-patient/{patientId}")
    public ResultDto<OrderDto[]> getByPatient(@PathVariable Long patientId) {
        return orderService.getOrdersByPatientId(patientId);
    }
}

