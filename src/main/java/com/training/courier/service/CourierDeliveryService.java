package com.training.courier.service;

import com.training.courier.exception.NotFoundException;
import com.training.courier.feignClient.CoreFeignClient;
import com.training.courier.model.CourierDelivery;
import com.training.courier.model.CourierDeliveryStatus;

import java.util.List;

/**
 * Service for work with {@link CourierDelivery courier delivery} entity
 */
public interface CourierDeliveryService {

    /**
     * Finds single {@link CourierDelivery courier delivery} in courier
     * microservice repository by unique identifier.
     *
     * @param id unique identifier of {@link CourierDelivery courier delivery}
     * @return {@link CourierDelivery courierDelivery}
     * @throws IllegalArgumentException in case of invalid input id provided
     * @throws NotFoundException in case of non existing {@link CourierDelivery courier delivery} in repository
     */
    CourierDelivery getById(Long id);

    /**
     * Finds all {@link List<CourierDelivery> courier deliveries} in courier
     * microservice repository.
     *
     * @return {@link List<CourierDelivery> courier deliveries}
     */
    List<CourierDelivery> getAll();

    /**
     * Finds {@link List<CourierDelivery> courier deliveries} from courier
     * microservice repository by {@link CourierDeliveryStatus status}
     *
     * @param status {@link CourierDeliveryStatus status} of {@link CourierDelivery courierDelivery}
     * @return {@link List<CourierDelivery> courier deliveries}
     * @throws IllegalArgumentException in case of invalid input {@link CourierDeliveryStatus status} provided
     */
    List<CourierDelivery> getByStatus(CourierDeliveryStatus status);

    /**
     * Saves new {@link CourierDelivery courier delivery} in courier microservice repository
     *
     * @param courierDelivery {@link CourierDelivery courier delivery} to be saved
     * @return {@link CourierDelivery courier delivery}
     * @throws IllegalArgumentException in case of invalid input {@link CourierDelivery courier delivery} provided
     */
    CourierDelivery save(CourierDelivery courierDelivery);

    /**
     * Updates {@link CourierDelivery courier delivery} in courier microservice repository
     *
     * @param id unique identifier of {@link CourierDelivery courier delivery} to be updated
     * @param courierDelivery {@link CourierDelivery courier delivery} to be updated
     * @return {@link CourierDelivery courier delivery}
     * @throws IllegalArgumentException in case of invalid input id or{@link CourierDelivery courier delivery} provided
     * @throws NotFoundException in case of non existing {@link CourierDelivery courier delivery} in repository
     */
    CourierDelivery update(Long id, CourierDelivery courierDelivery);

    /**
     * Gets pending {@link List<CourierDelivery> courier deliveries} from core
     * microservice repository through {@link CoreFeignClient core client}.
     *
     * @return {@link List<CourierDelivery> courier deliveries}
     */
    List<CourierDelivery> getPendingFromCore();

    /**
     * Updates {@link CourierDelivery courier delivery} in core microservice repository
     *
     * @param id unique identifier of {@link CourierDelivery courier delivery} to be updated
     * @param courierDelivery {@link CourierDelivery courier delivery} to be updated
     * @return {@link CourierDelivery courier delivery}
     */
    CourierDelivery updateInCore(Long id, CourierDelivery courierDelivery);

    /**
     * Gets pending {@link List<CourierDelivery> courier deliveries} from core microservice by schedule.
     * If {@link List<CourierDelivery> courier deliveries} exist, saves them in courier
     * microservice repository with IN_WAREHOUSE {@link CourierDeliveryStatus status}
     *
     * If deliveries with DELIVERED {@link CourierDeliveryStatus status} exist in courier microservice
     * repository, updates their status in core microservice repository to DELIVERED.
     * If operation is successful, updates their status in courier microservice repository to CLOSED.
     */
    void synchronizeDeliveries();
}