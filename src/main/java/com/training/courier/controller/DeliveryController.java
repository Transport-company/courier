package com.training.courier.controller;

import com.training.courier.Urls;
import com.training.courier.dto.request.DeliveryStatusRequest;
import com.training.courier.dto.response.DeliveriesPagedResponse;
import com.training.courier.dto.response.DeliveryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Deliveries", description = "Deliveries related interaction endpoints")
public interface DeliveryController {

    @Operation(summary = "Get information about delivery", responses =  {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = DeliveryResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Delivery not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping(Urls.Deliveries.Id.FULL)
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
    @GetMapping(Urls.Deliveries.FULL)
    ResponseEntity<DeliveriesPagedResponse> getList(@Parameter(name = "pageable",
                    description = "Response page parameters",
                    schema = @Schema(implementation = Pageable.class),
                    required = true)
            Pageable pageable);

    @Operation(summary = "Get information about deliveries filtered by status", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = DeliveriesPagedResponse.class))),
            @ApiResponse(responseCode = "204", description = "No content", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping(Urls.Deliveries.Filter.FULL)
    ResponseEntity<List<DeliveryResponse>> getFilteredDeliveries(@Parameter(name = "status",
                    description = "Delivery status to filter by",
                    schema = @Schema(implementation = DeliveryStatusRequest.class),
                    required = true)
            @RequestParam DeliveryStatusRequest status);

    @Operation(summary = "Update existing delivery status", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Delivery not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PatchMapping(Urls.Deliveries.Id.Status.FULL)
    ResponseEntity<String> changeStatus(@Parameter(name = "id",
                    description = "Delivery unique identifier",
                    required = true)
            @PathVariable("id") Long id,
                                        @Parameter(name = "status",
                    description = "Delivery status to update to",
                    schema = @Schema(implementation = DeliveryStatusRequest.class),
                    required = true)
            @RequestBody DeliveryStatusRequest status);

    @Operation(summary = "Verify code and update delivery status", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content),
            @ApiResponse(responseCode = "400", description = "Wrong confirmation code", content = @Content),
            @ApiResponse(responseCode = "404", description = "Delivery not found", content = @Content)})
    @PatchMapping(Urls.Deliveries.Id.FULL)
    ResponseEntity<String> verifyCodeAndUpdateDeliveryStatus(@Parameter(name = "id",
                    description = "Delivery unique identifier",
                    required = true)
            @PathVariable("id") Long id,
            @Parameter(name = "code",
                    description = "Delivery confirmation code",
                    schema = @Schema(example = "1234"),
                    required = true)
            @RequestBody String code);
}
