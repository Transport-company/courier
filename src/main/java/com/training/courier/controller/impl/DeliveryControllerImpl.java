package com.training.courier.controller.impl;

import com.training.courier.controller.DeliveryController;
import com.training.courier.dto.request.DeliveryUpdatingRequest;
import com.training.courier.dto.response.DeliveriesPagedResponse;
import com.training.courier.dto.response.DeliveryResponse;
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
    public ResponseEntity<DeliveriesPagedResponse> getPendingDeliveries(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<DeliveryResponse> updateDelivery(Long id, DeliveryUpdatingRequest deliveryUpdatingRequest) {
        return null;
    }
}
