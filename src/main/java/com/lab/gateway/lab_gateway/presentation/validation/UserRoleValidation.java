package com.lab.gateway.lab_gateway.presentation.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;
import com.lab.gateway.lab_gateway.infraestructure.service.UserService;

@Component
public class UserRoleValidation {
    @Autowired
    private UserService userService;

    public ResultDto<Void> ValidateAdminRole(Long userId) {
        var userResult = userService.getUserById(userId);
        if (!userResult.isSuccess()) {
            return ResultDto.fail(userResult.getErrorMessage());
        }

        var user = userResult.getData();

        if (!user.getRole().equals("ADMIN")) {
            return ResultDto.fail("Invalid Role");
        }

        return ResultDto.ok(null);
    }
}
