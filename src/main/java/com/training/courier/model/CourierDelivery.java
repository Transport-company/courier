package com.training.courier.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Courier delivery entity
 */
@Entity
@Table(name = "courier_delivery")
@Data
public class CourierDelivery {

    /**
     * Unique identifier
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    /**
     * Cargo information
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id", nullable = false)
    private Cargo cargo;

    /**
     * Courier information
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    private Courier courier;

    /**
     * Recipient client information
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;

    /**
     * Sending address (for returns)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sending_address_id", referencedColumnName = "id", nullable = false)
    private Address sendingAddress;

    /**
     * Shipping address
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id", nullable = false)
    private Address shippingAddress;

    /**
     * Confirmation code
     */
    @Column(name = "code")
    private String code;

    /**
     * Courier delivery status
     */
    @Enumerated(value = EnumType.STRING)
    @Column(name = "courier_delivery_status", nullable = false)
    private CourierDeliveryStatus courierDeliveryStatus;

    /**
     * Registration time
     */
    @CreationTimestamp
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    /**
     * Update time
     */
    @UpdateTimestamp
    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;
}