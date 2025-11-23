package com.lab.gateway.lab_gateway.presentation.dataTransferObject;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;

    @NotNull
    @Valid
    private PatientDto patient;

    @NotNull
    @PastOrPresent
    private LocalDateTime orderedAt;

    @NotBlank
    private String status;

    private String notes;
}
