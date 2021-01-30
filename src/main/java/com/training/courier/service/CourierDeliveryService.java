package com.training.courier.service;

import com.training.courier.feignClient.CoreFeignClient;
import com.training.courier.model.CourierDelivery;
import com.training.courier.model.CourierDeliveryStatus;
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
     * Finds {@link List<CourierDelivery> courier deliveries} from courier
     * microservice repository by {@link CourierDeliveryStatus status}
     *
     * @param status {@link CourierDeliveryStatus status} of {@link CourierDelivery courierDelivery}
     * @return {@link List<CourierDelivery> courier deliveries}
     */

    List<CourierDelivery> getBy(CourierDeliveryStatus status);

    /**
     * Saves {@link CourierDelivery courier delivery} in courier microservice repository
     *
     * @param courierDelivery {@link CourierDelivery courier delivery} to be saved
     * @return {@link CourierDelivery courier delivery}
     */
    @Transactional
    CourierDelivery save(@NonNull CourierDelivery courierDelivery);

    /**
     * Updates {@link CourierDelivery courier delivery} in courier microservice repository
     *
     * @param id unique identifier of {@link CourierDelivery courier delivery} to be updated
     * @param courierDelivery {@link CourierDelivery courier delivery}
     * @return {@link CourierDelivery courier delivery}
     */
    @Transactional
    CourierDelivery update(@NonNull Long id, @NonNull CourierDelivery courierDelivery);

    /**
     * Gets pending {@link List<CourierDelivery> courier deliveries} from core
     * microservice repository through {@link CoreFeignClient core client}.
     *
     * @return {@link List<CourierDelivery> courier deliveries}
     */
    @Scheduled
    List<CourierDelivery> getPendingFromCore();

    /**
     * Updates {@link CourierDelivery courier delivery} in core microservice repository
     *
     * @param id unique identifier of {@link CourierDelivery courier delivery} to be updated
     * @param courierDelivery {@link CourierDelivery courier delivery} to be updated
     * @return {@link CourierDelivery courier delivery}
     */
    @Scheduled
    CourierDelivery updateInCore(@NonNull Long id, @NonNull CourierDelivery courierDelivery);
}