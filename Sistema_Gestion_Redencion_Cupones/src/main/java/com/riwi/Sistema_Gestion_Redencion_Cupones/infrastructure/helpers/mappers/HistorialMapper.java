package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.mappers;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.HistorialRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.HistorialResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Historial;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.generics.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HistorialMapper extends GenericMapper<HistorialRequest, HistorialResponse, Historial> {
}
