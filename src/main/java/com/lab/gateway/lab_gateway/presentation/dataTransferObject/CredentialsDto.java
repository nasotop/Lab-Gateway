package com.lab.gateway.lab_gateway.presentation.dataTransferObject;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CredentialsDto {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
