package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.ProductResponse;
import org.springframework.data.domain.Page;

public interface IProductService {
    Page<ProductResponse> getAll(int page, int size);
}
