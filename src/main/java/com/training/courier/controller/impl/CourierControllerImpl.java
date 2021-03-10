package com.training.courier.controller.impl;

import com.training.courier.controller.CourierController;
import com.training.courier.dto.request.CourierRequest;
import com.training.courier.dto.response.CourierResponse;
import com.training.courier.dto.response.CouriersPagedResponse;
import com.training.courier.dto.response.SalaryResponse;
import com.training.courier.model.Courier;
import com.training.courier.service.CourierService;
import java.time.LocalDate;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CourierControllerImpl implements CourierController {

    private final CourierService courierService;
    private final ConversionService conversionService;

    @Override
    public ResponseEntity<CourierResponse> getById(Long id) {

        log.info("Started: get courier by id: {}", id);

        CourierResponse courierResponse = conversionService.convert(
                courierService.getById(id),
                CourierResponse.class);

        log.info("Ended: get courier by id, courier found");

        return ResponseEntity.ok(courierResponse);
    }

    @Override
    public ResponseEntity<CouriersPagedResponse> getList(Pageable pageable) {

        log.info("Started: get all couriers , page: {}, size: {}",
                pageable.getPageNumber(), pageable.getPageSize());

        CouriersPagedResponse couriersPagedResponse = conversionService.convert(
                courierService.getList(pageable),
                CouriersPagedResponse.class);

        log.info("Ended: get all couriers, found entries: {}",
                couriersPagedResponse.getTotalElements());

        return ResponseEntity.ok(couriersPagedResponse);
    }

    @Override
    public ResponseEntity<CourierResponse> create(CourierRequest courierRequest) {
        log.info("Started: create courier");

        CourierResponse courierResponse = conversionService.convert(
                courierService.save(
                        Objects.requireNonNull(
                                conversionService.convert(
                                        courierRequest,
                                        Courier.class))),
                CourierResponse.class);

        log.info("Ended: create courier, saved courier with id: {}", courierResponse.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(courierResponse);
    }

    @Override
    public ResponseEntity<CourierResponse> update(Long id, CourierRequest courierRequest) {
        log.info("Started: update courier with id: {}", id);

        CourierResponse courierResponse = conversionService.convert(
                courierService.update(
                        id,
                        Objects.requireNonNull(
                                conversionService.convert(
                                        courierRequest,
                                        Courier.class))),
                CourierResponse.class);

        log.info("Ended: update courier, success");

        return ResponseEntity.status(HttpStatus.OK).body(courierResponse);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        log.info("Started: delete courier with id: {}", id);

        courierService.delete(id);

        log.info("Ended: delete courier, success");

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<SalaryResponse> getMonthlySalary(Long id, LocalDate date) {
        return null;
    }
}
