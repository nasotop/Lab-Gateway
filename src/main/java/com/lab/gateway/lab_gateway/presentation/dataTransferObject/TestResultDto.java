package com.lab.gateway.lab_gateway.presentation.dataTransferObject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record TestResultDto(

        Long id,

        @NotNull @Positive Long orderTestId,

        @PastOrPresent LocalDateTime collectedAt,

        @PastOrPresent LocalDateTime processedAt,

        @NotBlank String value,

        @NotBlank String unit,

        @NotBlank String referenceRange,

        @NotBlank String interpretation,

        @NotBlank String status) {
}