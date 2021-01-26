package com.training.courier.dto.response;

import lombok.Data;

import java.util.List;

/**
 * Paged response for courier request
 */
@Data
public class CouriersPageResponse {

    /**
     * List of couriers
     */
    private List<CourierResponse> content;

    /**
     * Page size
     */
    private Integer pageSize;

    /**
     * Page number
     */
    private Integer pageNumber;

    /**
     * Total number of pages
     */
    private Integer totalPages;

    /**
     * Total number of elements
     */
    private Integer totalElements;
}