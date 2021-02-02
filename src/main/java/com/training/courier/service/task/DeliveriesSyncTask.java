package com.training.courier.service.task;

import com.training.courier.model.Delivery;
import com.training.courier.model.DeliveryStatus;
import java.util.List;

/**
 * Service for scheduled tasks
 */
public interface DeliveriesSyncTask {

    /**
     * Gets pending {@link List <Delivery> deliveries} from core microservice by schedule.
     * If {@link List<Delivery> deliveries} exist, saves them in courier microservice repository
     * with IN_WAREHOUSE {@link DeliveryStatus status}.
     *
     * If deliveries with DELIVERED {@link DeliveryStatus status} exist in courier microservice
     * repository, updates their status in core microservice repository to DELIVERED.
     * If operation is successful, updates their status in courier microservice repository to CLOSED.
     */
    void synchronizeDeliveries();
}
