package com.training.courier.service.impl;

import com.training.courier.model.Courier;
import com.training.courier.model.Salary;
import com.training.courier.service.SalaryService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class SalaryServiceImpl implements SalaryService {
    @Override
    public Salary save(Salary salary) {
        return null;
    }

    @Override
    public List<Salary> getAllByCourierInPeriod(Courier courier, LocalDate start, LocalDate end) {
        return null;
    }

    @Override
    public BigDecimal getSalarySumByCourierInPeriod(Courier courier, LocalDate start, LocalDate end) {
        return null;
    }
}
