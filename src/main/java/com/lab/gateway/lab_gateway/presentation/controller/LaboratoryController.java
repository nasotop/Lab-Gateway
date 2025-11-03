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
import com.lab.gateway.lab_gateway.infraestructure.service.LaboratoryService;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.LaboratoryDto;
import com.lab.gateway.lab_gateway.presentation.validation.UserRoleValidation;

@RestController
@RequestMapping("/api/laboratory")
@CrossOrigin(origins = "*")
public class LaboratoryController {
    @Autowired
    private LaboratoryService laboratoryService;
    @Autowired
    private UserRoleValidation userRoleValidation;

    @GetMapping("/{id}")
    public ResultDto<LaboratoryDto> getLaboratoryById(@PathVariable Long id, @RequestHeader("X-User-Id") Long userId) {
        var validateAdminRole = userRoleValidation.ValidateAdminRole(userId);
        if (!validateAdminRole.isSuccess()) {
            return ResultDto.fail(validateAdminRole.getErrorMessage());
        }
        return laboratoryService.getLaboratoryById(id);
    }

    @GetMapping("/all")
    public ResultDto<LaboratoryDto[]> getAllLaboratories() {

        return laboratoryService.getAllLaboratories();
    }

    @PostMapping("/create")
    public ResultDto<LaboratoryDto> createLaboratory(@RequestBody LaboratoryDto dto,
            @RequestHeader("X-User-Id") Long userId) {
        var validateAdminRole = userRoleValidation.ValidateAdminRole(userId);
        if (!validateAdminRole.isSuccess()) {
            return ResultDto.fail(validateAdminRole.getErrorMessage());
        }
        return laboratoryService.createLaboratory(dto);
    }

    @PostMapping("/update")
    public ResultDto<LaboratoryDto> updateLaboratory(@RequestBody LaboratoryDto dto,
            @RequestHeader("X-User-Id") Long userId) {
        var validateAdminRole = userRoleValidation.ValidateAdminRole(userId);
        if (!validateAdminRole.isSuccess()) {
            return ResultDto.fail(validateAdminRole.getErrorMessage());
        }
        return laboratoryService.updateLaboratory(dto.getId(), dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResultDto<String> deleteLaboratory(@PathVariable Long id, @RequestHeader("X-User-Id") Long userId) {
        var validateAdminRole = userRoleValidation.ValidateAdminRole(userId);
        if (!validateAdminRole.isSuccess()) {
            return ResultDto.fail(validateAdminRole.getErrorMessage());
        }
        return laboratoryService.deleteLaboratory(id);
    }

    @GetMapping("/by-specialization/{specialization}")
    public ResultDto<LaboratoryDto[]> getBySpecialization(@PathVariable String specialization) {
        return laboratoryService.getLaboratoriesBySpecialization(specialization);
    }
}
