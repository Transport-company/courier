package com.training.courier.service;

import com.training.courier.exception.DeliveryNotFoundException;
import com.training.courier.model.Courier;
import com.training.courier.model.Delivery;
import com.training.courier.model.DeliveryStatus;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     * Finds parametrized page of {@link Delivery delivery} in courier microservice repository.
     *
     * @param pageable Page parameters
     * @return {@link Page<Delivery> deliveries}
     */
    Page<Delivery> getList(Pageable pageable);

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
     * Finds {@link List<Delivery> deliveries} from courier microservice repository
     * by {@link Courier courier}.
     *
     * @param courier {@link DeliveryStatus status} assigned to {@link Delivery delivery}
     * @return {@link List<Delivery> deliveries}
     * @throws IllegalArgumentException in case of invalid input {@link Courier courier} provided
     */
    List<Delivery> getByCourier(Courier courier);

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

//    //todo
//    /**
//     * Verifies confirmation code of {@link Delivery delivery}, increments number of code verification attempts.
//     *
//     * @param id of {@link Delivery delivery}
//     * @param code of {@link Delivery delivery}
//     * @return result of verification
//     * @throws IllegalArgumentException in case of invalid input code provided
//     * @throws DeliveryNotFoundException in case of non existing {@link Delivery delivery} in repository
//     */
//    Boolean verifyCode(Long id, String code);

    //TODO
    /**
     * Verifies confirmation code of {@link Delivery delivery}, increments number of code verification attempts.
     * @param delivery {@link Delivery delivery}
     * @param code
     * @return
     */
    Boolean verifyCode(Delivery delivery, String code);

    /**
     * Assigns suitable {@link Courier courier} to {@link Delivery delivery}.
     *
     *
     * Changes {@link DeliveryStatus status} to ON_DELIVERY.
     * Increments number of delivery attempts.
     * Generates and saves confirmation code to {@link Delivery delivery}.
     * Reset number of code verification attempts.
     *
     * @param delivery {@link Delivery delivery}
     * @throws IllegalArgumentException in case of invalid input provided
     * @throws DeliveryNotFoundException in case of non existing {@link Delivery delivery} in repository
     */
    void assignCourier(Delivery delivery);

    /**
     * Gets pending {@link List<Delivery> deliveries} from core microservice
     * through {@link CoreFeignClient core client}.
     *
     * @return {@link List<Delivery> deliveries}
     */
    List<Delivery> getFromCorePendingDeliveries();

//    /**
//     * Updates {@link Delivery delivery} {@link DeliveryStatus status} in core
//     * microservice repository.//TODO salary
//     *
//     * @param id unique identifier of {@link Delivery delivery} to be updated
//     * @param status {@link DeliveryStatus status} to be updated
//     * @return {@link Delivery delivery}
//     */
//    Delivery updateInCore(Long id, DeliveryStatus status);

    void verifyCodeAndUpdateDeliveryInCoreAndCalculateSalary(Long id, String code);
    void test();
}
