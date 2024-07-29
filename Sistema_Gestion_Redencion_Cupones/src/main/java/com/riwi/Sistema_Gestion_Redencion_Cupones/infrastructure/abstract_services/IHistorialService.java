package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.HistorialRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.HistorialResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.User;

import java.util.List;

import org.apache.coyote.Request;

public interface IHistorialService extends GenericService<HistorialRequest, HistorialResponse, Long> {
    
    public List<HistorialResponse> findByUser(Long id);
}
