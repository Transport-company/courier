package com.training.courier.service;

import com.training.courier.exception.DeliveryNotFoundException;
import com.training.courier.feignClient.CoreFeignClient;
import com.training.courier.model.Courier;
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
     * Updates {@link Delivery delivery} {@link DeliveryStatus status} in courier microservice repository.
     *
     * @param id unique identifier of {@link Delivery delivery} to be updated
     * @param status {@link DeliveryStatus status} to be updated
     * @return {@link Delivery delivery}
     * @throws IllegalArgumentException in case of invalid input id or{@link Delivery delivery} provided
     * @throws DeliveryNotFoundException in case of non existing {@link Delivery delivery} in repository
     */
    Delivery update(Long id, DeliveryStatus status);

    /**
     * Verifies confirmation code of {@link Delivery delivery} if number of code verification attempts
     * doesn't exceed the limit. In case of negative result, increments number of code verification attempts.
     *
     * @param id of {@link Delivery delivery}
     * @param code of {@link Delivery delivery}
     * @return result of verification
     * @throws IllegalArgumentException in case of invalid input code provided
     * @throws DeliveryNotFoundException in case of non existing {@link Delivery delivery} in repository
     */
    Boolean verifyCode(Long id, String code);

    /**
     * Assigns {@link Courier courier} to {@link Delivery delivery}.
     * Changes {@link DeliveryStatus status} to ON_DELIVERY.
     * Generates and saves confirmation code to {@link Delivery delivery}.
     * Nullifies number of code verification attempts.
     *
     * @param id of {@link Delivery delivery}
     * @param courier {@link Courier courier} assigned to {@link Delivery delivery}
     * @throws IllegalArgumentException in case of invalid input {@link Courier courier} provided
     * @throws DeliveryNotFoundException in case of non existing {@link Delivery delivery} in repository
     */
    void assignCourier(Long id, Courier courier);

    /**
     * Gets pending {@link List<Delivery> deliveries} from core microservice repository
     * through {@link CoreFeignClient core client}.
     *
     * @return {@link List<Delivery> deliveries}
     */
    List<Delivery> getPendingFromCore();

    /**
     * Updates {@link Delivery delivery} {@link DeliveryStatus status} in core
     * microservice repository.
     *
     * @param id unique identifier of {@link Delivery delivery} to be updated
     * @param status {@link DeliveryStatus status} to be updated
     * @return {@link Delivery delivery}
     */
    Delivery updateInCore(Long id, DeliveryStatus status);
}
