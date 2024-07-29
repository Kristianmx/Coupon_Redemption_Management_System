package com.riwi.Sistema_Gestion_Redencion_Cupones.api.controllers;


import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.HistorialRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.HistorialResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.services.HistorialService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial")
@AllArgsConstructor
public class HistorialController {
    @Autowired
    private final HistorialService historialService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<HistorialResponse>> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.historialService.findByUser(id));
    }

    @PostMapping
    public ResponseEntity<HistorialResponse> create(@Validated @RequestBody HistorialRequest historialRequest){
        return ResponseEntity.ok(this.historialService.create(historialRequest));
    };
}
