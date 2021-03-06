package com.training.courier.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * Response object for delivery request
 */
@Data
@Builder
public class DeliveryResponse {

    /**
     * Unique identifier
     */
    @Schema(description = "Unique identifier", example = "1")
    private final Long id;

    /**
     * Cargo parameters
     */
    @Schema(description = "Cargo parameters")
    private final CargoResponse cargo;

    /**
     * Recipient client information
     */
    @Schema(description = "Recipient client information")
    private final ClientResponse recipient;

    /**
     * Shipping address
     */
    @Schema(description = "Shipping address")
    private final AddressResponse shippingAddress;

    /**
     * Registration time
     */
    @Schema(description = "Registration time")
    private final LocalDateTime created;

    /**
     * Update time
     */
    @Schema(description = "Update time")
    private final LocalDateTime updated;
}
