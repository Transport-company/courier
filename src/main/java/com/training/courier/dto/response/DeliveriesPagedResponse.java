package com.training.courier.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Data;

/**
 * Paged response object for deliveries request
 */
@Schema(description = "Paged response object for deliveries request")
@Data
public class DeliveriesPagedResponse {

    /**
     * List of deliveries
     */
    @Schema(description = "List of deliveries")
    private List<DeliveryResponse> content;

    /**
     * Page size
     */
    @Schema(description = "Page size")
    private Integer pageSize;

    /**
     * Page number
     */
    @Schema(description = "Page number")
    private Integer pageNumber;

    /**
     * Total number of pages
     */
    @Schema(description = "Total number of pages")
    private Integer totalPages;

    /**
     * Total number of elements
     */
    @Schema(description = "Total number of elements")
    private Integer totalElements;
}
