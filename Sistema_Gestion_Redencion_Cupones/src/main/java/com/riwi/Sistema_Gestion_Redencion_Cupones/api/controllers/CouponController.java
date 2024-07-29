package com.riwi.Sistema_Gestion_Redencion_Cupones.api.controllers;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.CouponRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.CouponResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services.ICouponService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/coupons")
@AllArgsConstructor
@Tag(name = "Coupon Controller", description = "Controller for managing coupons")
public class CouponController {

    @Autowired
    private final ICouponService couponService;

    @Operation(summary = "Get all coupons", description = "Retrieves a paginated list of all coupons")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of coupons"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<Page<CouponResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.couponService.getAll(page - 1, size));
    }

    @Operation(summary = "Get coupon by ID", description = "Retrieves a specific coupon based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the coupon"),
            @ApiResponse(responseCode = "404", description = "Coupon not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<CouponResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.couponService.get(id));
    }

    @Operation(summary = "Create a new coupon", description = "Creates a new coupon with the provided details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created the coupon"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<CouponResponse> insert(@Validated @RequestBody CouponRequest request) {
        return ResponseEntity.ok(this.couponService.create(request));
    }

    @Operation(summary = "Update an existing coupon", description = "Updates the details of an existing coupon based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated the coupon"),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Coupon not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<CouponResponse> update(@Validated @RequestBody CouponRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.couponService.update(id, request));
    }

    @Operation(summary = "Delete a coupon", description = "Deletes a specific coupon based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted the coupon"),
            @ApiResponse(responseCode = "404", description = "Coupon not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.couponService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
