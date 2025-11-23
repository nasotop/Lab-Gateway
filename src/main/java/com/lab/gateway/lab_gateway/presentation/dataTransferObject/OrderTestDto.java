package com.lab.gateway.lab_gateway.presentation.dataTransferObject;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderTestDto {

    private Long id;

    @NotNull
    @Positive
    private Long orderId;

    @NotNull
    @Positive
    private Long testTypeId;

    @NotNull
    @Positive
    private Long laboratoryId;

    @NotBlank
    private String priority;

    @NotBlank
    private String status;

    @FutureOrPresent
    private LocalDateTime scheduledStart;

    @FutureOrPresent
    private LocalDateTime scheduledEnd;
}
