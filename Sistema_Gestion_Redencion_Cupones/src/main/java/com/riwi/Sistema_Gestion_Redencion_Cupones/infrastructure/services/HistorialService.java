package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.services;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.HistorialRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.HistorialResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Coupons;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Historial;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Product;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.User;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories.CouponRepository;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories.HistorialRepository;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories.ProductRepository;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories.UserRepository;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services.IHistorialService;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.mappers.HistorialMapper;
import com.riwi.Sistema_Gestion_Redencion_Cupones.utils.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class HistorialService implements IHistorialService {

    @Autowired
    private final HistorialMapper historialMapper;

    @Autowired
    private final HistorialRepository historialRepository;
    @Autowired
    private  final UserRepository userRepository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final CouponRepository couponRepository;
    @Override
    public HistorialResponse create(HistorialRequest historialRequest) {
        Historial historial = this.historialMapper.toEntity(historialRequest);
        User user = this.userRepository.findById(historialRequest.getUserId()).orElseThrow(()-> new IdNotFoundException("User"));
        Product product= this.productRepository.findById(historialRequest.getProductsId()).orElseThrow(()->new IdNotFoundException("Product"));
        Coupons coupons = this.couponRepository.findById(historialRequest.getCuponId()).orElseThrow(()->new IdNotFoundException("Coupon"));
        historial.setCoupons(coupons);
        historial.setUser(user);
        historial.setProduct(product);
        historial.setStatus(true);
        historial.setRedemptionDate(LocalDateTime.now());

        return this.historialMapper.toResponse(this.historialRepository.save(historial));
    }

    @Override
    public HistorialResponse get(Long Long) {

        return null;
    }

    @Override
    public HistorialResponse update(Long aLong, HistorialRequest historialRequest) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public List<HistorialResponse> findByUser(Long id) {
        List<Historial> historials = this.historialRepository.findAllByUser_Id(id);
        return this.historialMapper.toListResponse(historials);
    }

  


}
