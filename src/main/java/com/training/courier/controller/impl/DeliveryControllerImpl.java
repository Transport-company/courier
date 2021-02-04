package com.training.courier.controller.impl;

import com.training.courier.controller.DeliveryController;
import com.training.courier.dto.request.DeliveryStatusRequest;
import com.training.courier.dto.response.DeliveriesPagedResponse;
import com.training.courier.dto.response.DeliveryResponse;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryControllerImpl implements DeliveryController {


    @Override
    public ResponseEntity<DeliveryResponse> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<DeliveriesPagedResponse> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<List<DeliveryResponse>> getFilteredDeliveries(DeliveryStatusRequest status) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateDeliveryStatus(Long id, DeliveryStatusRequest status) {
        return null;
    }

    @Override
    public ResponseEntity<DeliveryResponse> verifyCodeAndUpdateDeliveryStatus(Long id, String code) {
        return null;
    }
}
