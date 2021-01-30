package com.training.courier.service;

import com.training.courier.client.CoreClient;
import com.training.courier.model.CourierDelivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * service for work with {@link CourierDelivery courier delivery} entity
 */
public interface CourierDeliveryService {

    /**
     * Finds single {@link CourierDelivery courier delivery} in courier
     * microservice repository by unique identifier.
     *
     * @param id unique identifier of {@link CourierDelivery courier delivery}
     * @return {@link CourierDelivery courierDelivery}
     */
    CourierDelivery getById(@NonNull Long id);

    /**
     * Finds all {@link List<CourierDelivery> courier deliveries} in courier
     * microservice repository.
     *
     * @return {@link List<CourierDelivery> courier deliveries}
     */
    List<CourierDelivery> getAll();

    /**
     * Finds all pending {@link List<CourierDelivery> courier deliveries} in core
     * microservice repository through {@link CoreClient core client}. Then saves all
     * nonexistent deliveries in courier microservice repository.
     * If core microservice is unavailable, finds all pending
     * {@link List<CourierDelivery> courier deliveries} in courier microservice repository.
     *
     * @return {@link List<CourierDelivery> courier deliveries}
     */
    @Scheduled
    List<CourierDelivery> getPending();

    /**
     * Updates {@link CourierDelivery courier delivery} in core microservice repository
     * through {@link CoreClient core client}. If update in core is successful, updates
     * {@link CourierDelivery courier delivery} in courier microservice repository with
     * is_synchronized = true flag. //TODO добавить boolean поле
     * If core microservice  is unavailable, updates {@link CourierDelivery courier delivery}
     * in courier microservice repository with is_synchronized = false flag.
     *
     * @param courierDelivery {@link CourierDelivery courier delivery}
     * @return {@link CourierDelivery courier delivery}
     */
    @Transactional
    CourierDelivery save(@NonNull CourierDelivery courierDelivery);
}