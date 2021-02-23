package com.training.courier.service.impl;

import com.training.courier.exception.CourierAlreadyExistsException;
import com.training.courier.exception.CourierNotFoundException;
import com.training.courier.model.Courier;
import com.training.courier.repository.CourierRepository;
import com.training.courier.service.CourierService;
import java.util.List;
import java.util.Random;
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

        log.info("Find courier with id: {} processed", id);

        Courier courier =  courierRepository.findById(id)
                .orElseThrow(() -> new CourierNotFoundException(id));

        log.info("Found courier with provided id");

        return courier;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Courier> getAllPageable(@NonNull Pageable pageable) {
        log.info("Find all couriers , page: {}, size: {} processed",
                pageable.getPageNumber(), pageable.getPageSize());

        return courierRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Courier getRandomActiveByCityWithMinimalActiveTasks(@NonNull String city) {
        Assert.notNull(city, "City parameter mustn't be null");

        log.info("Find active courier by city: \"{}\" with minimal active tasks processed", city);

        List<Courier> suitableCouriers = courierRepository.findActiveByCityWithMinimalActiveTasks(city);

        if (suitableCouriers.isEmpty()) {
            log.info("No suitable courier found");
            return null;
        }

        log.info("Found suitable couriers: {}", suitableCouriers.size());

        Random random = new Random();
        Courier courier = suitableCouriers.get(random.nextInt(suitableCouriers.size()));

        log.info("Selected courier with id: {}", courier.getId());

        return courier;
    }

    @Override
    @Transactional
    public Courier save(@NonNull Courier courier) {
        Assert.notNull(courier, "Courier object mustn't be null");

        log.info("Save courier processed");

        if (courierRepository.existsByPhoneNumber(courier.getPhoneNumber())) {
            throw new CourierAlreadyExistsException(courier.getPhoneNumber());
        }

        Courier savedCourier = courierRepository.save(courier);

        log.info("Saved courier with id: {}", savedCourier.getId());

        return savedCourier;
    }

    @Override
    @Transactional
    public Courier update(@NonNull Long id, @NonNull Courier courier) {
        Assert.notNull(id, "Id mustn't be null");
        Assert.notNull(courier, "Courier object mustn't be null");

        log.info("Update courier with id: {} processed", id);

        Courier foundCourier =  getById(id);

        if (!courier.getPhoneNumber().equals(foundCourier.getPhoneNumber()) &&
                courierRepository.existsByPhoneNumber(courier.getPhoneNumber())) {
            throw new CourierAlreadyExistsException(courier.getPhoneNumber());
        }

        courier.setId(id);
        courier.setCreated(foundCourier.getCreated());

        Courier updatedCourier = courierRepository.save(courier);

        log.info("Updated courier with provided id");

        return updatedCourier;
    }

    @Override
    @Transactional
    public void delete(@NonNull Long id) {
        Assert.notNull(id, "Id mustn't be null");

        log.info("Delete courier with id: {} processed", id);

        courierRepository.delete(getById(id));

        log.info("Deleted courier with id: {}", id);
    }
}
