package com.training.courier.service;

import com.training.courier.exception.NotFoundException;
import com.training.courier.model.Cargo;
import com.training.courier.model.Courier;
import com.training.courier.model.CourierDelivery;
import com.training.courier.model.Salary;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Service for work with {@link Salary salary} entity
 */
public interface SalaryService {

    /**
     * Saves new {@link Salary salary entry} in courier microservice repository
     *
     * @param courier {@link Courier courier}
     * @param calculatingDate date of calculation
     * @param baseRate base rate per one delivery
     * @param weightFactor depends on {@link Cargo cargo} weight
     * @param volumeFactor depends on {@link Cargo cargo} dimensions
     * @param distanceFactor depends on {@link CourierDelivery courier delivery} distance
     * @return {@link Salary salary}
     * @throws IllegalArgumentException in case of invalid input arguments provided
     */
    Salary save(
            Courier courier,
            LocalDate calculatingDate,
            BigDecimal baseRate,
            BigDecimal weightFactor,
            BigDecimal volumeFactor,
            BigDecimal distanceFactor);

    /**
     * Finds all {@link List<Salary> salary entries} in courier microservice repository by courier id
     * in provided period.
     *
     * @param courier {@link Courier courier}
     * @param start start date
     * @param end end date
     * @return {@link List<Salary> salary entries}
     * @throws IllegalArgumentException in case of invalid arguments provided
     * @throws NotFoundException in case of non existing {@link Courier courier} in repository
     */
    List<Salary> getAllByCourierInPeriod(Courier courier, LocalDate start, LocalDate end);

    /**
     * Returns salary sum of {@link Courier courier} in provided period
     *
     * @param courier {@link Courier courier}
     * @param start start date
     * @param end end date
     * @return {@link List<Salary> salary entries}
     * @throws IllegalArgumentException in case of invalid id or dates provided
     * @throws NotFoundException in case of non existing {@link Courier courier} in repository
     */
    BigDecimal getSalarySumByCourierInPeriod(Courier courier, LocalDate start, LocalDate end);
}