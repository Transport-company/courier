package com.training.courier.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Paged response for courier request
 */
@Data
@Builder
public class CouriersPagedResponse {

    /**
     * List of couriers
     */
    @Schema(description = "List of couriers")
    private final List<CourierResponse> content;

    /**
     * Page size
     */
    @Schema(description = "Page size")
    private final Integer pageSize;

    /**
     * Page number
     */
    @Schema(description = "Page number")
    private final Integer pageNumber;

    /**
     * Total number of pages
     */
    @Schema(description = "Total number of pages")
    private final Integer totalPages;

    /**
     * Total number of elements
     */
    @Schema(description = "Total number of elements")
    private final Integer totalElements;
}
