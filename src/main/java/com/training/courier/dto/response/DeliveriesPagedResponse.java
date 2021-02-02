package com.training.courier.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Data;

/**
 * Paged response object for courier deliveries request
 */
@Schema(description = "Paged response object for courier deliveries request")
@Data
public class CourierDeliveriesPageResponse {

    /**
     * List of courier deliveries
     */
    @Schema(description = "List of courier deliveries")
    private List<CourierDeliveryResponse> content;

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