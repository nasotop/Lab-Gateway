package com.lab.gateway.lab_gateway.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.service.TestResultService;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.TestResultDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/test-results")
public class TestResultController {

    @Autowired
    private TestResultService testResultService;


    @PostMapping
    public ResponseEntity<ResultDto<TestResultDto>> create(
            @Valid @RequestBody TestResultDto dto) {

        

        var result = testResultService.create(dto);
        return buildResponse(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultDto<TestResultDto>> update(
            @PathVariable Long id,
            @Valid @RequestBody TestResultDto dto) {

       

        var result = testResultService.update(id, dto);
        return buildResponse(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResultDto<TestResultDto>> delete(
            @PathVariable Long id) {

        var result = testResultService.delete(id);
        return buildResponse(result);
    }

    @GetMapping
    public ResponseEntity<ResultDto<TestResultDto[]>> getAll() {
        var result = testResultService.getAll();
        return buildResponse(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultDto<TestResultDto>> getById(
            @PathVariable Long id) {

        var result = testResultService.getById(id);
        return buildResponse(result);
    }

    @GetMapping("/order-test/{orderTestId}")
    public ResponseEntity<ResultDto<TestResultDto>> getByOrderTestId(
            @PathVariable Long orderTestId) {

        var result = testResultService.getByOrderTestId(orderTestId);
        return buildResponse(result);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ResultDto<TestResultDto[]>> getByStatus(
            @PathVariable String status) {

        var result = testResultService.getByStatus(status);
        return buildResponse(result);
    }

    @GetMapping("/status")
    public ResponseEntity<ResultDto<String[]>> getStatuses() {

        var result = testResultService.getStatuses();
        return buildResponse(result);
    }
    private <T> ResponseEntity<ResultDto<T>> buildResponse(ResultDto<T> result) {
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
