package com.training.courier.model;

/**
 * Delivery status
 */
public enum CourierDeliveryStatus {

    /**
     * In warehouse
     */
    IN_WAREHOUSE,

    /**
     * Picked up by courier, on delivery
     */
    ON_DELIVERY,

    /**
     * Delivery successful
     */
    DELIVERED,

    /**
     * Unsuccessful attempt of delivery, returning to warehouse
     */
    ON_RETURN,

    /**
     * In case of emergency situation
     */
    LOST
}