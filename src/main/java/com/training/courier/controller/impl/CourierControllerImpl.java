package com.training.courier.controller.impl;

import com.training.courier.controller.CourierController;
import com.training.courier.dto.request.CourierRequest;
import com.training.courier.dto.response.CourierResponse;
import com.training.courier.dto.response.CouriersPagedResponse;
import com.training.courier.dto.response.SalaryResponse;
import com.training.courier.model.Courier;
import com.training.courier.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CourierControllerImpl implements CourierController {

    private final CourierService courierService;
    private final ConversionService conversionService;

    @Override
    public ResponseEntity<CourierResponse> getById(Long id) {

        return ResponseEntity.ok(
                conversionService.convert(courierService.getById(id), CourierResponse.class));
    }

    @Override
    public ResponseEntity<CouriersPagedResponse> getAll(Pageable pageable) {

        return ResponseEntity.ok(
                conversionService.convert(courierService.getAll(pageable), CouriersPagedResponse.class));
    }

    @Override
    public ResponseEntity<CourierResponse> create(CourierRequest courierRequest) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(conversionService.convert(
                        courierService.save(conversionService.convert(courierRequest, Courier.class)),
                        CourierResponse.class));
    }

    @Override
    public ResponseEntity<CourierResponse> update(Long id, CourierRequest courierRequest) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(conversionService.convert(
                        courierService.update(id, conversionService.convert(courierRequest, Courier.class)),
                        CourierResponse.class));
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        courierService.delete(id);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<SalaryResponse> getMonthly(Long id) {
        return null;
    }
}
