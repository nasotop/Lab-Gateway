package com.lab.gateway.lab_gateway.infraestructure.service.apiService;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;

import com.lab.gateway.lab_gateway.domain.dataTransferObject.ResultDto;

public final class TypeRefs {
    private TypeRefs() {}

    // Permite crear ParameterizedTypeReference<ResultDto<T>> sin clases anónimas explícitas
    public static <T> ParameterizedTypeReference<ResultDto<T>> resultOf(Class<T> inner) {
        ResolvableType type = ResolvableType.forClassWithGenerics(ResultDto.class, inner);
        @SuppressWarnings("unchecked")
        ParameterizedTypeReference<ResultDto<T>> ref =
                ParameterizedTypeReference.forType(type.getType());
        return ref;
    }
}