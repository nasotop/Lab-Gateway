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
import com.lab.gateway.lab_gateway.infraestructure.service.LaboratoryService;
import com.lab.gateway.lab_gateway.presentation.dataTransferObject.LaboratoryDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {
    @Autowired
    private LaboratoryService laboratoryService;
    

    @GetMapping("/{id}")
    public ResultDto<LaboratoryDto> getLaboratoryById(@PathVariable Long id) {
       
        return laboratoryService.getLaboratoryById(id);
    }

    @GetMapping("/all")
    public ResultDto<LaboratoryDto[]> getAllLaboratories() {

        return laboratoryService.getAllLaboratories();
    }

    @PostMapping("/create")
    public ResultDto<LaboratoryDto> createLaboratory(@Valid @RequestBody LaboratoryDto dto) {
       
        return laboratoryService.createLaboratory(dto);
    }

    @PostMapping("/update")
    public ResultDto<LaboratoryDto> updateLaboratory(@Valid @RequestBody LaboratoryDto dto) {

        return laboratoryService.updateLaboratory(dto.getId(), dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResultDto<String> deleteLaboratory(@PathVariable Long id) {
       
        return laboratoryService.deleteLaboratory(id);
    }

    @GetMapping("/by-specialization/{specialization}")
    public ResultDto<LaboratoryDto[]> getBySpecialization(@PathVariable String specialization) {
        return laboratoryService.getLaboratoriesBySpecialization(specialization);
    }
}
