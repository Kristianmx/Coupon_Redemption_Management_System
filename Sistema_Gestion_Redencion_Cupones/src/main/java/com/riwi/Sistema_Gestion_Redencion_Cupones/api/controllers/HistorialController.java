package com.riwi.Sistema_Gestion_Redencion_Cupones.api.controllers;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.HistorialRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.HistorialResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.services.HistorialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial")
@AllArgsConstructor
@Tag(name = "Historial Controller", description = "Controller for managing user history")
public class HistorialController {

    @Autowired
    private final HistorialService historialService;

    @Operation(summary = "Get user history by ID", description = "Retrieves the history records of a user based on their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the user history"),
            @ApiResponse(responseCode = "404", description = "User history not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<List<HistorialResponse>> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.historialService.findByUser(id));
    }

    @Operation(summary = "Create a new history record", description = "Creates a new history record for a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created the history record"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<HistorialResponse> create(@Validated @RequestBody HistorialRequest historialRequest) {
        return ResponseEntity.ok(this.historialService.create(historialRequest));
    }
}
