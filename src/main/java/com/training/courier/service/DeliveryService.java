package com.training.courier.service;

import com.training.courier.exception.DeliveryNotFoundException;
import com.training.courier.feignClient.CoreFeignClient;
import com.training.courier.model.DeliveryStatus;
import com.training.courier.model.Delivery;
import java.util.List;

/**
 * Service for work with {@link Delivery courier delivery} entity
 */
public interface CourierDeliveryService {

    /**
     * Finds single {@link Delivery courier delivery} in courier
     * microservice repository by unique identifier.
     *
     * @param id unique identifier of {@link Delivery courier delivery}
     * @return {@link Delivery courierDelivery}
     * @throws IllegalArgumentException in case of invalid input id provided
     * @throws DeliveryNotFoundException in case of non existing {@link Delivery courier delivery} in repository
     */
    Delivery getById(Long id);

    /**
     * Finds all {@link List< Delivery > courier deliveries} in courier
     * microservice repository.
     *
     * @return {@link List< Delivery > courier deliveries}
     */
    List<Delivery> getAll();

    /**
     * Finds {@link List< Delivery > courier deliveries} from courier
     * microservice repository by {@link DeliveryStatus status}
     *
     * @param status {@link DeliveryStatus status} of {@link Delivery courierDelivery}
     * @return {@link List< Delivery > courier deliveries}
     * @throws IllegalArgumentException in case of invalid input {@link DeliveryStatus status} provided
     */
    List<Delivery> getByStatus(DeliveryStatus status);

    /**
     * Saves new {@link Delivery courier delivery} in courier microservice repository
     *
     * @param delivery {@link Delivery courier delivery} to be saved
     * @return {@link Delivery courier delivery}
     * @throws IllegalArgumentException in case of invalid input {@link Delivery courier delivery} provided
     */
    Delivery save(Delivery delivery);

    /**
     * Updates {@link Delivery courier delivery} in courier microservice repository
     *
     * @param id unique identifier of {@link Delivery courier delivery} to be updated
     * @param delivery {@link Delivery courier delivery} to be updated
     * @return {@link Delivery courier delivery}
     * @throws IllegalArgumentException in case of invalid input id or{@link Delivery courier delivery} provided
     * @throws DeliveryNotFoundException in case of non existing {@link Delivery courier delivery} in repository
     */
    Delivery update(Long id, Delivery delivery);

    /**
     * Gets pending {@link List< Delivery > courier deliveries} from core
     * microservice repository through {@link CoreFeignClient core client}.
     *
     * @return {@link List< Delivery > courier deliveries}
     */
    List<Delivery> getPendingFromCore();

    /**
     * Updates {@link Delivery courier delivery} in core microservice repository
     *
     * @param id unique identifier of {@link Delivery courier delivery} to be updated
     * @param delivery {@link Delivery courier delivery} to be updated
     * @return {@link Delivery courier delivery}
     */
    Delivery updateInCore(Long id, Delivery delivery);
}