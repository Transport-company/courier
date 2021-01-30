package com.training.courier.service;

import com.training.courier.exception.NotFoundException;
import com.training.courier.model.Courier;

import java.util.List;

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
     * @throws NotFoundException in case of non existing {@link Courier courier} in repository
     */
    Courier getById(Long id);

    /**
     * Finds all {@link List<Courier> couriers} in courier microservice repository.
     *
     * @return {@link List<Courier> couriers}
     */
    List<Courier> getAll();

    /**
     * Saves new {@link Courier courier} in courier microservice repository
     *
     * @param courier {@link Courier courier} to be saved
     * @return {@link Courier courier}
     * @throws IllegalArgumentException in case of invalid input {@link Courier courier} provided
     */
    Courier save(Courier courier);

    /**
     * Updates {@link Courier courier} in courier microservice repository
     *
     * @param id unique identifier of {@link Courier courier} to be updated
     * @param courier {@link Courier courier} to be updated
     * @return {@link Courier courier}
     * @throws IllegalArgumentException in case of invalid input id or{@link Courier courier} provided
     * @throws NotFoundException in case of non existing {@link Courier courier} in repository
     */
    Courier update(Long id, Courier courier);


    /**
     * Deletes {@link Courier courier} from courier microservice repository
     *
     * @param id unique identifier of {@link Courier courier}
     * @throws IllegalArgumentException in case of invalid input id or{@link Courier courier} provided
     * @throws NotFoundException in case of non existing {@link Courier courier} in repository
     */
    void delete(Long id);
}