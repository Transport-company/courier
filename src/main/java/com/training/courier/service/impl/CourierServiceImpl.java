package com.training.courier.service.impl;

import com.training.courier.exception.CourierAlreadyExistsException;
import com.training.courier.exception.CourierNotFoundException;
import com.training.courier.model.Courier;
import com.training.courier.repository.CourierRepository;
import com.training.courier.service.CourierService;
import com.training.courier.util.RandomCreator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;

    @Override
    @Transactional(readOnly = true)
    public Courier getById(@NonNull Long id) {
        Assert.notNull(id, "Id mustn't be null");

        log.debug("Started: get courier by id: {}", id);

        Courier courier =  courierRepository.findById(id)
                .orElseThrow(() -> new CourierNotFoundException(id));

        log.debug("Ended: get courier by id");

        return courier;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Courier> getList(@NonNull Pageable pageable) {
        log.debug("Started: get all couriers , page: {}, size: {} processed",
                pageable.getPageNumber(), pageable.getPageSize());

        Page<Courier> couriersPagedList = courierRepository.findAll(pageable);

        log.debug("Ended: get all couriers");

        return couriersPagedList;
    }

    @Override
    @Transactional
    public Courier save(@NonNull Courier courier) {
        Assert.notNull(courier, "Courier object mustn't be null");

        log.debug("Started: save courier");

        if (courierRepository.existsByPhoneNumber(courier.getPhoneNumber())) {
            throw new CourierAlreadyExistsException(courier.getPhoneNumber());
        }

        courier.setTasksNumber(0);

        Courier savedCourier = courierRepository.save(courier);

        log.debug("Ended: save courier");

        return savedCourier;
    }

    @Override
    @Transactional
    public Courier update(@NonNull Long id, @NonNull Courier courier) {
        Assert.notNull(id, "Id mustn't be null");
        Assert.notNull(courier, "Courier object mustn't be null");

        log.debug("Started: update courier with id: {}", id);

        Courier foundCourier =  getById(id);

        if (!courier.getPhoneNumber().equals(foundCourier.getPhoneNumber()) &&
                courierRepository.existsByPhoneNumber(courier.getPhoneNumber())) {
            throw new CourierAlreadyExistsException(courier.getPhoneNumber());
        }

        courier.setId(id);
        courier.setTasksNumber(foundCourier.getTasksNumber());
        courier.setCreated(foundCourier.getCreated());

        Courier updatedCourier = courierRepository.save(courier);

        log.debug("Ended: update courier");

        return updatedCourier;
    }

    @Override
    @Transactional
    public void delete(@NonNull Long id) {
        Assert.notNull(id, "Id mustn't be null");

        log.debug("Started: delete courier with id: {}", id);

        courierRepository.delete(getById(id));

        log.debug("Ended: delete courier");
    }

    @Override
    @Transactional(readOnly = true)
    public Courier getActiveByCityWithMinimalTasksNumber(@NonNull String city) {
        Assert.notNull(city, "City parameter mustn't be null");

        log.debug("Started: get active courier by city: \"{}\" with minimal tasks number", city);

        List<Courier> suitableCouriers = courierRepository.findActiveByCityWithMinimalTasksNumber(city);

        if (suitableCouriers.isEmpty()) {
            throw new CourierNotFoundException(city);
        }

        Courier courier = suitableCouriers.get(RandomCreator.generateInt(suitableCouriers.size()));

        log.debug("Ended: get active courier by city: \"{}\" with minimal tasks number. Selected courier with id: {}", city, courier.getId());

        return courier;
    }

    void incrementTasksNumber(Courier courier) {
        courierRepository.incrementTasksNumber(courier);
    }

    void decrementTasksNumber(Courier courier) {
        courierRepository.decrementTasksNumber(courier);
    }
}
