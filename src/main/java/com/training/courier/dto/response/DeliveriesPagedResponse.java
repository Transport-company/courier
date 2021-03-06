package com.training.courier.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * Paged response object for deliveries request
 */
@Data
@Builder
public class DeliveriesPagedResponse {

    /**
     * List of deliveries
     */
    @Schema(description = "List of deliveries")
    private final List<DeliveryResponse> content;

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
