package com.training.courier.service.task;

import com.training.courier.model.Delivery;
import com.training.courier.model.DeliveryStatus;
import java.util.List;

/**
 * Service for scheduled tasks
 */
public interface DeliveryTask {

    /**
     * Gets pending {@link List <Delivery> deliveries} from core microservice.
     * If {@link List<Delivery> deliveries} exist, saves them in courier microservice repository
     * with IN_WAREHOUSE {@link DeliveryStatus status}/
     */
    void getPendingDeliveries();

    /**
     * Assigns couriers to {@link List <Delivery> deliveries} with IN_WAREHOUSE
     * {@link DeliveryStatus status}
     */
    void assignCouriers();

    /**
     * Finds {@link List <Delivery> deliveries} with RETURNING_TO_WAREHOUSE
     * {@link DeliveryStatus status}. If delivery attempts number doesn't exceed the limit,
     * changes {@link DeliveryStatus status} to IN_WAREHOUSE
     */
    void retryUnsuccessfulDeliveries();

    /**
     * Finds {@link List <Delivery> deliveries} with isSynchronized = false, makes an attempt
     * to synchronize them with core microservice.
     */
    void synchronizeDeliveries();
}
