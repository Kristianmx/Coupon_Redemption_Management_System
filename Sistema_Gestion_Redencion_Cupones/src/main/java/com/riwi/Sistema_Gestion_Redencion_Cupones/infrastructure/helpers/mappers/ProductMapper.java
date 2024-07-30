package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.mappers;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.ProductResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    ProductResponse toResponse(Product product);
}
