package com.training.courier.model;

/**
 * Delivery status
 */
public enum DeliveryStatus {

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
     * Delivery job completed, status synchronized with core
     */
    CLOSED,

    /**
     * Unsuccessful attempt of delivery, returning to warehouse
     */
    ON_RETURN,

    /**
     * In case of emergency situation
     */
    LOST
}
