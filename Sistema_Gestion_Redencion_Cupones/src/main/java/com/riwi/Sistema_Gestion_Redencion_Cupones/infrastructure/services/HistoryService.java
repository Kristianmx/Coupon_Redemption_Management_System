package com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.services;

import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.requests.HistoryRequest;
import com.riwi.Sistema_Gestion_Redencion_Cupones.api.dtos.responses.HistoryResponse;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Coupons;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.History;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Product;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.User;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories.CouponRepository;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories.HistoryRepository;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories.ProductRepository;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories.UserRepository;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.abstract_services.IHistoryService;
import com.riwi.Sistema_Gestion_Redencion_Cupones.infrastructure.helpers.mappers.HistoryMapper;
import com.riwi.Sistema_Gestion_Redencion_Cupones.utils.exceptions.BadRequestException;
import com.riwi.Sistema_Gestion_Redencion_Cupones.utils.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class HistoryService implements IHistoryService {

    @Autowired
    private final HistoryMapper historyMapper;

    @Autowired
    private final HistoryRepository historyRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final CouponRepository couponRepository;

    @Override
    public HistoryResponse create(HistoryRequest historyRequest) {
        History history = this.historyMapper.toEntity(historyRequest);
        User user = this.userRepository.findById(historyRequest.getUserId())
                .orElseThrow(() -> new IdNotFoundException("User"));
        Product product = this.productRepository.findById(historyRequest.getProductsId())
                .orElseThrow(() -> new IdNotFoundException("Product"));
        Coupons coupons = this.couponRepository.findById(historyRequest.getCuponId())
                .orElseThrow(() -> new IdNotFoundException("Coupon"));
        history.setCoupons(coupons);
        history.setUser(user);
        history.setProduct(product);
        history.setStatus(true);
        history.setRedemptionDate(LocalDateTime.now());

        List<History> list = this.historyRepository.findAll();

        list.forEach(his -> {
            if (his.getUser().getId().equals(historyRequest.getUserId())
                    && his.getCoupons().getId().equals(historyRequest.getCuponId())) {
                throw new BadRequestException("This coupon has already been used");
            }

        });

        return this.historyMapper.toResponse(this.historyRepository.save(history));
    }

    @Override
    public HistoryResponse get(Long id) {
        History history = this.findHistory(id);
        return this.historyMapper.toResponse(history);
    }

    @Override
    public HistoryResponse update(Long aLong, HistoryRequest historyRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {
        History history = this.findHistory(id);
        this.historyRepository.delete(history);
    }

    @Override
    public List<HistoryResponse> findByUser(Long id) {
        List<History> histories = this.historyRepository.findAllByUser_Id(id);
        return this.historyMapper.toListResponse(histories);
    }

    @Override
    public History findHistory(Long id) {
        return this.historyRepository.findById(id).orElseThrow(() -> new IdNotFoundException("History"));
    }

}
