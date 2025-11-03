package com.lab.gateway.lab_gateway.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.lab.gateway.lab_gateway.infraestructure.service.PatientService;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.PatientDto;
import com.lab.gateway.lab_gateway.presentation.validation.UserRoleValidation;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService service;
    @Autowired
    private UserRoleValidation userRoleValidation;

    @PostMapping("create-patient")
    public ResultDto<PatientDto> create(@RequestBody PatientDto dto, @RequestHeader("X-User-Id") Long userId) {
        var validateAdminRole = userRoleValidation.ValidateAdminRole(userId);
        if (!validateAdminRole.isSuccess()) {
            return ResultDto.fail(validateAdminRole.getErrorMessage());
        }
        return service.createPatient(dto);
    }

    @PostMapping("update-patient/{id}")
    public ResultDto<PatientDto> update(@PathVariable Long id, @RequestBody PatientDto dto,
            @RequestHeader("X-User-Id") Long userId) {
        var validateAdminRole = userRoleValidation.ValidateAdminRole(userId);
        if (!validateAdminRole.isSuccess()) {
            return ResultDto.fail(validateAdminRole.getErrorMessage());
        }
        return service.updatePatient(id, dto);
    }

    @DeleteMapping("delete-patient/{id}")
    public ResultDto<String> delete(@PathVariable Long id,
            @RequestHeader("X-User-Id") Long userId) {
        var validateAdminRole = userRoleValidation.ValidateAdminRole(userId);
        if (!validateAdminRole.isSuccess()) {
            return ResultDto.fail(validateAdminRole.getErrorMessage());
        }
        return service.deletePatient(id);
    }

    @GetMapping("get-all-patients")
    public ResultDto<PatientDto[]> getAll(
            @RequestHeader("X-User-Id") Long userId) {
        var validateAdminRole = userRoleValidation.ValidateAdminRole(userId);
        if (!validateAdminRole.isSuccess()) {
            return ResultDto.fail(validateAdminRole.getErrorMessage());
        }
        return service.getAllPatients();
    }

    @GetMapping("get-patient-by-id/{id}")
    public ResultDto<PatientDto> getById(@PathVariable Long id,
            @RequestHeader("X-User-Id") Long userId) {
        var validateAdminRole = userRoleValidation.ValidateAdminRole(userId);
        if (!validateAdminRole.isSuccess()) {
            return ResultDto.fail(validateAdminRole.getErrorMessage());
        }
        return service.getPatientById(id);
    }

}
