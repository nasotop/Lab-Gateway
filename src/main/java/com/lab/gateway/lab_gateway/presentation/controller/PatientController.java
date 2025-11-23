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
import com.lab.gateway.lab_gateway.infraestructure.service.PatientService;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.PatientDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping("create-patient")
    public ResultDto<PatientDto> create(@Valid @RequestBody PatientDto dto) {

        return service.createPatient(dto);
    }

    @PostMapping("update-patient/{id}")
    public ResultDto<PatientDto> update(@PathVariable Long id, @Valid @RequestBody PatientDto dto) {

        return service.updatePatient(id, dto);
    }

    @DeleteMapping("delete-patient/{id}")
    public ResultDto<String> delete(@PathVariable Long id) {

        return service.deletePatient(id);
    }

    @GetMapping("get-all-patients")
    public ResultDto<PatientDto[]> getAll() {

        return service.getAllPatients();
    }

    @GetMapping("get-patient-by-id/{id}")
    public ResultDto<PatientDto> getById(@PathVariable Long id) {

        return service.getPatientById(id);
    }

}
