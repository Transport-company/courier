package com.training.courier.service;

import com.training.courier.exception.CourierAlreadyExistsException;
import com.training.courier.exception.CourierNotFoundException;
import com.training.courier.model.Courier;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service for work with {@link Courier courier} entity
 */
public interface CourierService {

    /**
     * Finds single {@link Courier courier} in courier microservice repository by unique identifier.
     *
     * @param id unique identifier of {@link Courier courier}
     * @return {@link Courier courier}
     * @throws IllegalArgumentException in case of invalid id provided
     * @throws CourierNotFoundException in case of non existing {@link Courier courier} in repository
     */
    Courier getById(Long id);

    /**
     * Finds parametrized page of {@link List<Courier> couriers} in courier microservice repository.
     *
     * @param pageable Page parameters
     * @return {@link Page<Courier> couriers}
     */
    Page<Courier> getAllPageable(Pageable pageable);

    /**
     * Finds {@link Courier courier} in courier microservice repository by isActive = true
     * and by city with minimal active tasks. If there are more than one suitable couriers,
     * returns a random one of them.
     *
     * @param city of {@link Courier courier}
     * @return {@link Courier courier}
     * @throws IllegalArgumentException in case of invalid input state provided
     * @throws CourierNotFoundException in case of non existing suitable {@link Courier courier} in repository
     */
    Courier getRandomActiveByCityWithMinimalActiveTasks(String city);

    /**
     * Saves new {@link Courier courier} in courier microservice repository.
     *
     * @param courier {@link Courier courier} to be saved
     * @return {@link Courier courier}
     * @throws IllegalArgumentException in case of invalid input {@link Courier courier} provided
     * @throws CourierAlreadyExistsException in case of already existing {@link Courier courier}
     * with provided phone number
     */
    Courier save(Courier courier);

    /**
     * Updates {@link Courier courier} in courier microservice repository.
     *
     * @param id unique identifier of {@link Courier courier} to be updated
     * @param courier {@link Courier courier} to be updated
     * @return {@link Courier courier}
     * @throws IllegalArgumentException in case of invalid input id or{@link Courier courier} provided
     * @throws CourierNotFoundException in case of non existing {@link Courier courier} in repository
     * @throws CourierAlreadyExistsException in case of already existing {@link Courier courier}
     * with provided phone number
     */
    Courier update(Long id, Courier courier);

    /**
     * Deletes {@link Courier courier} from courier microservice repository.
     *
     * @param id unique identifier of {@link Courier courier}
     * @throws IllegalArgumentException in case of invalid input id or{@link Courier courier} provided
     * @throws CourierNotFoundException in case of non existing {@link Courier courier} in repository
     */
    void delete(Long id);
}
