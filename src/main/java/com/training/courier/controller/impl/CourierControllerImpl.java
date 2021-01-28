package com.training.courier.controller.impl;

import com.training.courier.controller.CourierController;
import com.training.courier.dto.request.CreateCourierRequest;
import com.training.courier.dto.request.UpdateCourierRequest;
import com.training.courier.dto.response.CourierResponse;
import com.training.courier.dto.response.CouriersPageResponse;
import com.training.courier.dto.response.SalaryResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourierControllerImpl implements CourierController {

    @Override
    public ResponseEntity<CourierResponse> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CouriersPageResponse> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<CourierResponse> create(CreateCourierRequest createCourierRequest) {
        return null;
    }

    @Override
    public ResponseEntity<CourierResponse> update(Long id, UpdateCourierRequest updateCourierRequest) {
        return null;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<SalaryResponse> getMonthly(Long id) {
        return null;
    }
}
