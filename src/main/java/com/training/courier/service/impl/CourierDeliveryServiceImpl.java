package com.training.courier.service.impl;

import com.training.courier.feignClient.CoreFeignClient;
import com.training.courier.model.CourierDelivery;
import com.training.courier.model.CourierDeliveryStatus;
import com.training.courier.service.CourierDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public class CourierDeliveryServiceImpl implements CourierDeliveryService {

    private final CoreFeignClient coreFeignClient;

    @Override
    public CourierDelivery getById(@NonNull Long id) {
        return null;
    }

    @Override
    public List<CourierDelivery> getAll() {
        return null;
    }

    @Override
    public List<CourierDelivery> getByStatus(@NonNull CourierDeliveryStatus status) {
        return null;
    }

    @Override
    @Transactional
    public CourierDelivery save(@NonNull CourierDelivery courierDelivery) {
        return null;
    }

    @Override
    @Transactional
    public CourierDelivery update(@NonNull Long id, @NonNull CourierDelivery courierDelivery) {
        return null;
    }

    @Override
    public List<CourierDelivery> getPendingFromCore() {
        return null;
    }

    @Override
    public CourierDelivery updateInCore(@NonNull Long id, @NonNull CourierDelivery courierDelivery) {
        return null;
    }

    @Override
    @Scheduled(cron = "${cron.expression}")
    public void synchronizeDeliveries() {
    }
}