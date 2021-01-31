package com.training.courier.service.impl;

import com.training.courier.model.Courier;
import com.training.courier.service.CourierService;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CourierServiceImpl implements CourierService {

    @Override
    public Courier getById(@NonNull Long id) {
        return null;
    }

    @Override
    public List<Courier> getAll() {
        return null;
    }

    @Override
    @Transactional
    public Courier save(@NonNull Courier courier) {
        return null;
    }

    @Override
    @Transactional
    public Courier update(@NonNull Long id, @NonNull Courier courier) {
        return null;
    }

    @Override
    @Transactional
    public void delete(@NonNull Long id) {
    }
}