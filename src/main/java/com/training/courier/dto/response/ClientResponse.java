package com.training.courier.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * Response object for client request
 */
@Data
@Builder
public class ClientResponse {

    /**
     * Unique identifier
     */
    @Schema(description = "Unique identifier", example = "1")
    private final Long id;

    /**
     * First name
     */
    @Schema(description = "First name", example = "Petr")
    private final String firstName;

    /**
     * Middle name
     */
    @Schema(description = "Middle name", example = "Petrovich")
    private final String middleName;

    /**
     * Last name
     */
    @Schema(description = "Last name", example = "Petrov")
    private final String lastName;

    /**
     * Date of birth
     */
    @Schema(description = "Date of birth", example = "20.02.1970")
    private final LocalDate birthday;

    /**
     * Phone number
     */
    @Schema(description = "Phone number", example = "89054446622")
    private final String phoneNumber;

    /**
     * Email
     */
    @Schema(description = "email", example = "petrovPP@yahoo.com")
    private final String email;

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
