package com.training.courier.service.impl;

import com.training.courier.model.Courier;
import com.training.courier.model.Salary;
import com.training.courier.service.SalaryService;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class SalaryServiceImpl implements SalaryService {

    @Override
    @Transactional
    public Salary save(
            @NonNull Courier courier,
            @NonNull LocalDate calculatingDate,
            @NonNull BigDecimal baseRate,
            @NonNull BigDecimal weightFactor,
            @NonNull BigDecimal volumeFactor,
            @NonNull BigDecimal distanceFactor) {
        return null;
    }

    @Override
    public List<Salary> getAllByCourierInPeriod(
            @NonNull Courier courier,
            @NonNull LocalDate start,
            @NonNull LocalDate end) {
        return null;
    }

    @Override
    public BigDecimal getSalarySumByCourierInPeriod(
            @NonNull Courier courier,
            @NonNull LocalDate start,
            @NonNull LocalDate end) {
        return null;
    }
}