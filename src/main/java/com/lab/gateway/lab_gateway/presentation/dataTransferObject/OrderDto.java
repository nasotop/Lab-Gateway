package com.lab.gateway.lab_gateway.presentation.dataTransferObject;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private PatientDto patient;
    private LocalDateTime orderedAt;
    private String status;
    private String notes;
}
