package com.lab.gateway.lab_gateway.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.service.ParametersService;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.ParameterDto;

@RestController
@RequestMapping("/api/parameter")
@CrossOrigin
public class ParametersController {
    
    @Autowired
    private ParametersService service;

    @GetMapping("get-order-status")
    public ResultDto<ParameterDto[]> getOrderStatus() {
        return service.getOrderStatus();
    }   
    @GetMapping("get-priorities")
    public ResultDto<ParameterDto[]> getPriorities() {
        return service.getPriorities();
    }
    @GetMapping("get-specializations")
    public ResultDto<ParameterDto[]> getSpecializations() {
        return service.getSpecializations();
    }   
    @GetMapping("get-test-status")
    public ResultDto<ParameterDto[]> getTestStatus() {
        return service.getTestStatus();
    }
}
