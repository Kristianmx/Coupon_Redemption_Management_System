package com.riwi.Sistema_Gestion_Redencion_Cupones.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.CouponRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.CouponResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services.ICouponService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/coupons")
@AllArgsConstructor
public class CouponController {

    @Autowired
    private final ICouponService couponService;

   @GetMapping
    public ResponseEntity<Page<CouponResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        return ResponseEntity.ok(this.couponService.getAll(page - 1, size));

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CouponResponse> get(
        @PathVariable Long id) {
        return ResponseEntity.ok(this.couponService.get(id));
    }

    @PostMapping
    public ResponseEntity<CouponResponse> insert(
            @Validated
            @RequestBody CouponRequest request) {
        return ResponseEntity.ok(this.couponService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CouponResponse> update(
            @Validated
            @RequestBody CouponRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.couponService.update(id,request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.couponService.delete(id);
        return ResponseEntity.noContent().build();
    }
 
}
