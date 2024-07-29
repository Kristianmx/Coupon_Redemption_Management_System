package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.HistorialRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.HistorialResponse;
import org.apache.coyote.Request;

public interface IHistorialService extends GenericService<HistorialRequest, HistorialResponse, Long>{
}
