package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.HistoryRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.HistoryResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.History;

import java.util.List;

public interface IHistoryService extends GenericService<HistoryRequest, HistoryResponse, Long> {

    public List<HistoryResponse> findByUser(Long id);

    History findHistory(Long id);
}
