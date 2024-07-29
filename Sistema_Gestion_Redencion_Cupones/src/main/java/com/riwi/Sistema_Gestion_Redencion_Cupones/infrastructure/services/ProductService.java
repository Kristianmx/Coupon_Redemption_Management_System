package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.services;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.ProductResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories.ProductRepository;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services.IProductService;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.mappers.ProductMapper;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ProductMapper productMapper;


    @Override
    public Page<ProductResponse> getAll(int page, int size) {
        if (page < 0) {
            page = 0;
        }

        PageRequest pageable = PageRequest.of(page, size);


        return this.productRepository.findAll(pageable).map(author -> this.productMapper.toResponse(author));
    }
}
