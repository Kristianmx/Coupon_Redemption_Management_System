package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.CouponRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.CouponResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Coupons;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories.CouponRepository;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services.ICouponService;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.mappers.CouponMapper;
import com.riwi.Sistema_Gestion_Redencion_Cupones.utils.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CouponService implements ICouponService {
    
    @Autowired
    private final CouponRepository couponRepository;

    @Autowired
    private final CouponMapper couponMapper;
    
    @Override
    public CouponResponse create(CouponRequest request) {

        Coupons coupon =this.couponMapper.toEntity(request);
        return couponMapper.toResponse(this.couponRepository.save(coupon));
    }

    @Override
    public CouponResponse get(Long id) {
        return this.couponMapper.toResponse(this.find(id));
    }

    @Override
    public CouponResponse update(Long id, CouponRequest request) {
        Coupons coupon = this.find(id);
        coupon = this.couponMapper.toEntity(request);
        return this.couponMapper.toResponse(this.couponRepository.save(coupon));
    }

    @Override
    public void delete(Long id) {
        Coupons coupon= this.find(id);
        this.couponRepository.delete(coupon);
    }

    private Coupons find(Long id){
        return this.couponRepository.findById(id)
        .orElseThrow(()->new IdNotFoundException("coupons"));
    }

    @Override
    public Page<CouponResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = null;

        pagination = PageRequest.of(page, size);
        
        return this.couponRepository.findAll(pagination)
                .map(user ->  (this.couponMapper.toResponse(user)));
    }
    
}
