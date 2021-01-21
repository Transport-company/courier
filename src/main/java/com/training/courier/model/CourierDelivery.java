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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Cargo information
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id", nullable = false)
    private Cargo cargo;

    /**
     * Courier information
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id", referencedColumnName = "id", nullable = false)
    private Courier courier;

    /**
     * Recipient client information
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;

    /**
     * Sending address (for returns)
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sending_address_id", referencedColumnName = "id", nullable = false)
    private Address sendingAddress;

    /**
     * Shipping address
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id", nullable = false)
    private Address shippingAddress;

    /**
     * Confirmation code
     */
    @Column(name = "code")
    private String code;

    /**
     * Delivery status
     */
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

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