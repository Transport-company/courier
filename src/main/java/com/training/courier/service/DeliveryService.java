package com.training.courier.service;

import com.training.courier.exception.DeliveryNotFoundException;
import com.training.courier.feignClient.CoreFeignClient;
import com.training.courier.model.Delivery;
import com.training.courier.model.DeliveryStatus;
import java.util.List;

/**
 * Service for work with {@link Delivery delivery} entity
 */
public interface DeliveryService {

    /**
     * Finds single {@link Delivery delivery} in courier microservice repository by unique identifier.
     *
     * @param id unique identifier of {@link Delivery delivery}
     * @return {@link Delivery delivery}
     * @throws IllegalArgumentException in case of invalid input id provided
     * @throws DeliveryNotFoundException in case of non existing {@link Delivery delivery} in repository
     */
    Delivery getById(Long id);

    /**
     * Finds all {@link List<Delivery> deliveries} in courier microservice repository.
     *
     * @return {@link List<Delivery> deliveries}
     */
    List<Delivery> getAll();

    /**
     * Finds {@link List<Delivery> deliveries} from courier microservice repository
     * by {@link DeliveryStatus status}.
     *
     * @param status {@link DeliveryStatus status} of {@link Delivery delivery}
     * @return {@link List<Delivery> deliveries}
     * @throws IllegalArgumentException in case of invalid input {@link DeliveryStatus status} provided
     */
    List<Delivery> getByStatus(DeliveryStatus status);

    /**
     * Saves new {@link Delivery delivery} in courier microservice repository.
     *
     * @param delivery {@link Delivery delivery} to be saved
     * @return {@link Delivery delivery}
     * @throws IllegalArgumentException in case of invalid input {@link Delivery delivery} provided
     */
    Delivery save(Delivery delivery);

    /**
     * Updates {@link Delivery delivery} in courier microservice repository.
     *
     * @param id unique identifier of {@link Delivery delivery} to be updated
     * @param delivery {@link Delivery delivery} to be updated
     * @return {@link Delivery delivery}
     * @throws IllegalArgumentException in case of invalid input id or{@link Delivery delivery} provided
     * @throws DeliveryNotFoundException in case of non existing {@link Delivery delivery} in repository
     */
    Delivery update(Long id, Delivery delivery);

    /**
     * Gets pending {@link List<Delivery> deliveries} from core microservice repository
     * through {@link CoreFeignClient core client}.
     *
     * @return {@link List<Delivery> deliveries}
     */
    List<Delivery> getPendingFromCore();

    /**
     * Updates {@link Delivery delivery} in core microservice repository.
     *
     * @param id unique identifier of {@link Delivery delivery} to be updated
     * @param delivery {@link Delivery delivery} to be updated
     * @return {@link Delivery delivery}
     */
    Delivery updateInCore(Long id, Delivery delivery);
}
