package com.lab.gateway.lab_gateway.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.service.TestTypeService;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.TestTypeDto;

@RestController
@RequestMapping("/api/test-type")
public class TestTypeController {

    @Autowired
    private TestTypeService service;

    @PostMapping("create-test-type")
    public ResultDto<TestTypeDto> create(@RequestBody TestTypeDto dto) {
        return service.createTestType(dto);
    }

    @PostMapping("update-test-type/{id}")
    public ResultDto<TestTypeDto> update(@PathVariable Long id, @RequestBody TestTypeDto dto) {
        return service.updateTestType(id, dto);
    }

    @DeleteMapping("delete-test-type/{id}")
    public ResultDto<String> delete(@PathVariable Long id) {
        return service.deleteTestType(id);
    }

    @GetMapping("get-all-test-types")
    public ResultDto<TestTypeDto[]> getAll() {
        return service.getAllTestTypes();
    }

    @GetMapping("get-test-type-by-id/{id}")
    public ResultDto<TestTypeDto> getById(@PathVariable Long id) {
        return service.getTestTypeById(id);
    }

    @GetMapping("get-test-types-by-specialization/{specialization}")
    public ResultDto<TestTypeDto[]> getBySpecialization(@PathVariable String specialization) {
        return service.getTestTypesBySpecialization(specialization);
    }
}
