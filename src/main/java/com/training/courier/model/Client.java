package com.training.courier.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Recipient client entity
 */
@Entity
@Table(name = "client")
@Data
public class Client {

    /**
     * Unique identifier
     */
    @Column(name = "id")
    private Long id;

    /**
     * Name
     */
    @Column(name = "name")
    private String name;

    /**
     * Email
     */
    @Column(name = "email")
    private String email;

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