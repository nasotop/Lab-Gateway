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
public class OrderTestDto {
    private Long id;
    private OrderDto order;
    private TestTypeDto testType;
    private LaboratoryDto laboratory;
    private String priority;
    private String status;
    private LocalDateTime scheduledStart;
    private LocalDateTime scheduledEnd;
}