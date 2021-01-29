package com.training.courier.controller.impl;

import com.training.courier.controller.CourierDeliveryController;
import com.training.courier.dto.request.UpdateCourierDeliveryRequest;
import com.training.courier.dto.response.CourierDeliveriesPageResponse;
import com.training.courier.dto.response.CourierDeliveryResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourierDeliveryControllerImpl implements CourierDeliveryController {

    @Override
    public ResponseEntity<CourierDeliveryResponse> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CourierDeliveriesPageResponse> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<CourierDeliveriesPageResponse> getPendingDeliveries(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<CourierDeliveryResponse> updateDelivery(Long id, UpdateCourierDeliveryRequest updateCourierDeliveryRequest) {
        return null;
    }
}
