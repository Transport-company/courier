package com.training.courier.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * Response object for address request
 */
@Data
@Builder
public class AddressResponse {

    /**
     * Unique identifier
     */
    @Schema(description = "Unique identifier", example = "1")
    private final Long id;

    /**
     * Country region
     */
    @Schema(description = "Country region", example = "Samarskaya obl..")
    private final String region;

    /**
     * City
     */
    @Schema(description = "City", example = "Samara")
    private final String city;

    /**
     * Street
     */
    @Schema(description = "Street", example = "Lenina")
    private final String street;

    /**
     * House number
     */
    @Schema(description = "House number", example = "10")
    private final String house;

    /**
     * Apartment number
     */
    @Schema(description = "Apartment number", example = "20")
    private final String apartment;

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
