package com.training.courier.controller;

import com.training.courier.Urls;
import com.training.courier.dto.request.DeliveryUpdatingRequest;
import com.training.courier.dto.response.DeliveriesPagedResponse;
import com.training.courier.dto.response.DeliveryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Deliveries", description = "Deliveries related interaction endpoints")
public interface DeliveryController {

    @Operation(summary = "Get information about delivery", responses =  {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = DeliveryResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Delivery not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping(Urls.CourierDeliveries.Id.FULL)
    ResponseEntity<DeliveryResponse> getById(@Parameter(name = "id",
                    description = "Delivery unique identifier",
                    required = true)
            @PathVariable("id") Long id);

    @Operation(summary = "Get paged information about all deliveries", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = DeliveriesPagedResponse.class))),
            @ApiResponse(responseCode = "204", description = "No content", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping(Urls.CourierDeliveries.FULL)
    ResponseEntity<DeliveriesPagedResponse> getAll(@Parameter(name = "pageable",
                    description = "Response page parameters",
                    schema = @Schema(implementation = Pageable.class),
                    required = true)
            Pageable pageable);

    @Operation(summary = "Get paged information about pending deliveries", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = DeliveriesPagedResponse.class))),
            @ApiResponse(responseCode = "204", description = "No content", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping(Urls.CourierDeliveries.Pending.FULL)
    ResponseEntity<DeliveriesPagedResponse> getPendingDeliveries(@Parameter(name = "pageable",
                    description = "Response page parameters",
                    schema = @Schema(implementation = Pageable.class),
                    required = true)
            Pageable pageable);

    @Operation(summary = "Edit existing delivery status", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = DeliveryResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Delivery not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PatchMapping(Urls.CourierDeliveries.Id.FULL)
    ResponseEntity<DeliveryResponse> updateDelivery(@Parameter(name = "id",
                    description = "Delivery unique identifier",
                    required = true)
            @PathVariable("id") Long id,
            @Parameter(name = "deliveryUpdatingRequest",
                    description = "Delivery status contained in update request",
                    schema = @Schema(implementation = DeliveryUpdatingRequest.class),
                    required = true)
            @RequestBody DeliveryUpdatingRequest deliveryUpdatingRequest);
}
