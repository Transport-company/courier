package com.training.courier.model;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


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
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    /**
     * Courier information
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    private Courier courier;

    /**
     * Recipient client information
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;

    /**
     * Shipping address
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    private Address address;

    /**
     * Confirmation code
     */
    @Column(name = "code")
    private String code;

    /**
     * Number of code verification attempts
     */
    @Column(name = "verify_code_attempts_number", columnDefinition = "int2 default 0")
    private Integer verifyCodeAttemptsNumber;

    /**
     * Number of delivery attempts
     */
    @Column(name = "delivery_attempts_number", columnDefinition = "int2 default 0")
    private Integer deliveryAttemptsNumber;

    /**
     * Courier delivery status
     */
    @Enumerated(value = EnumType.STRING)
    @Column(name = "courier_delivery_status", nullable = false)
    private DeliveryStatus deliveryStatus;

    /**
     * Delivery status is synchronized with core microservice
     */
    @Column(name = "is_synchronized", columnDefinition = "boolean default false", nullable = false)
    private boolean isSynchronized;

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
