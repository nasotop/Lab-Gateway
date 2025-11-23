package com.lab.gateway.lab_gateway.presentation.dataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LaboratoryDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String location;

    @NotNull
    @Positive
    private Integer capacity;

    @NotBlank
    private String specialization;
}