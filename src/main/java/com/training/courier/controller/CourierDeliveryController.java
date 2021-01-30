package com.training.courier.controller;

import com.training.courier.Urls;
import com.training.courier.dto.request.UpdateCourierDeliveryRequest;
import com.training.courier.dto.response.CourierDeliveriesPageResponse;
import com.training.courier.dto.response.CourierDeliveryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Courier deliveries", description = "Courier deliveries related interaction endpoints")
public interface CourierDeliveryController {

    @Operation(summary = "Get information about courier delivery", responses =  {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CourierDeliveryResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Courier delivery not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping(Urls.CourierDeliveries.Id.FULL)
    ResponseEntity<CourierDeliveryResponse> getById(@Parameter(name = "id",
                    description = "Courier delivery unique identifier",
                    required = true)
            @PathVariable("id") Long id);

    @Operation(summary = "Get paged information about all courier deliveries", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CourierDeliveriesPageResponse.class))),
            @ApiResponse(responseCode = "204", description = "No content", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping(Urls.CourierDeliveries.FULL)
    ResponseEntity<CourierDeliveriesPageResponse> getAll(@Parameter(name = "pageable",
                    description = "Response page parameters",
                    schema = @Schema(implementation = Pageable.class),
                    required = true)
            Pageable pageable);

    @Operation(summary = "Get paged information about pending courier deliveries", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CourierDeliveriesPageResponse.class))),
            @ApiResponse(responseCode = "204", description = "No content", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping(Urls.CourierDeliveries.Pending.FULL)
    ResponseEntity<CourierDeliveriesPageResponse> getPendingDeliveries(@Parameter(name = "pageable",
                    description = "Response page parameters",
                    schema = @Schema(implementation = Pageable.class),
                    required = true)
            Pageable pageable);

    @Operation(summary = "Edit existing courier delivery information", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CourierDeliveryResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Courier delivery not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PutMapping(Urls.CourierDeliveries.Id.FULL)
    ResponseEntity<CourierDeliveryResponse> updateDelivery(@Parameter(name = "id",
                    description = "Courier unique identifier",
                    required = true)
            @PathVariable("id") Long id,
            @Parameter(name = "updateCourierDelivery",
                    description = "Courier delivery data contained in update request",
                    schema = @Schema(implementation = UpdateCourierDeliveryRequest.class),
                    required = true)
            @RequestBody UpdateCourierDeliveryRequest updateCourierDeliveryRequest);
}