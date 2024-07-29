package com.riwi.Sistema_Gestion_Redencion_Cupones.api.controllers;


import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.ProductResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll(@RequestParam(defaultValue = "1") int page,
                                                        @RequestParam(defaultValue = "8") int size) {
        Page<ProductResponse> productResponses = this.productService.getAll (page - 1, size);
        return ResponseEntity.ok(productResponses);
    }
}
