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
@Table(name = "delivery")
@Data
public class Delivery {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cargo information
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

    /**
     * Courier information
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    private Courier courier;

    /**
     * Recipient client information
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    /**
     * Sending address (for returns)
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sending_address_id", referencedColumnName = "id")
    private Address sendingAddress;

    /**
     * Shipping address
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private Address shippingAddress;

    /**
     * Confirmation code
     */
    @Column(name = "code")
    private String code;

    /**
     * Delivery status
     */
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    /**
     * Registration time
     */
    @CreationTimestamp
    @Column(name = "created")
    private LocalDateTime created;

    /**
     * Update time
     */
    @UpdateTimestamp
    @Column(name = "updated")
    private LocalDateTime updated;
}