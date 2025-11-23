package com.lab.gateway.lab_gateway.presentation.dataTransferObject;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private Long id;

    @NotNull
    private Long userId;

    @NotBlank
    private String fullName;

    @NotNull
    @Past
    private LocalDate birthDate;

    @NotBlank
    private String sex;

    @NotBlank
    @Pattern(regexp = "^[0-9+\\-() ]{6,20}$")
    private String phone;

    @NotBlank
    @Email
    private String email;
}
