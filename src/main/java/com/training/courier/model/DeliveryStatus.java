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
     * Returning to warehouse after unsuccessful attempt of delivery
     */
    RETURNING_TO_WAREHOUSE,

    /**
     * Handed over to recipient
     */
    HANDED_OVER,

    /**
     * Delivery successful, entry is closed
     */
    DELIVERED,

    /**
     * Returning to sender after unsuccessful attempts of delivery
     */
    RETURNED,

    /**
     * In case of emergency situation
     */
    LOST
}
