package com.training.courier.controller;

import com.training.courier.Urls;
import com.training.courier.dto.request.CourierRequest;
import com.training.courier.dto.response.CourierResponse;
import com.training.courier.dto.response.CouriersPagedResponse;
import com.training.courier.dto.response.SalaryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDate;
import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Couriers", description = "Courier related interaction endpoints")
public interface CourierController {

    @Operation(
            summary = "Get information about courier",
            responses =  {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CourierResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Courier not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping(Urls.Couriers.Id.FULL)
    ResponseEntity<CourierResponse> getById(
            @Parameter(name = "id", description = "Courier unique identifier", required = true)
            @PathVariable("id") Long id);

    @Operation(
            summary = "Get paged information about all couriers",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CouriersPagedResponse.class))),
                    @ApiResponse(responseCode = "204", description = "No content", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping(Urls.Couriers.FULL)
    ResponseEntity<CouriersPagedResponse> getList(
            @Parameter(
                    name = "pageable",
                    description = "Response page parameters",
                    schema = @Schema(implementation = Pageable.class),
                    required = true)
            Pageable pageable);

    @Operation(summary = "Create new courier",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully created",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation =  CourierResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "409", description = "Already exists", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping(Urls.Couriers.FULL)
    ResponseEntity<CourierResponse> create(
            @Parameter(
                    name = "createCourierRequest",
                    description = "Courier data contained in create request",
                    schema = @Schema(implementation = CourierRequest.class),
                    required = true)
            @Valid
            @RequestBody CourierRequest courierRequest);

    @Operation(
            summary = "Edit existing courier information",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully updated",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CourierResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Courier not found", content = @Content),
                    @ApiResponse(responseCode = "409", description = "Already exists", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PutMapping(Urls.Couriers.Id.FULL)
    ResponseEntity<CourierResponse> update(
            @Parameter(name = "id", description = "Courier unique identifier", required = true)
            @PathVariable("id") Long id,
            @Parameter(
                    name = "courierUpdatingRequest",
                    description = "Courier data contained in update request",
                    schema = @Schema(implementation = CourierRequest.class),
                    required = true)
            @Valid
            @RequestBody CourierRequest courierUpdatingRequest);

    @Operation(
            summary = "Delete existing courier",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully deleted", content = @Content),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Courier not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @DeleteMapping(Urls.Couriers.Id.FULL)
    ResponseEntity<String> delete(
            @Parameter(name = "id", description = "Courier unique identifier", required = true)
            @PathVariable("id") Long id);

    @Operation(
            summary = "Get courier salary for current month",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = SalaryResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Courier not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping(Urls.Couriers.Id.Salary.FULL)
    ResponseEntity<SalaryResponse> getMonthlySalary(
            @Parameter(name = "id", description = "Courier unique identifier", required = true)
            @PathVariable("id") Long id,
            @Parameter(name = "date", description = "Month of salary calculation", required = true)
            @RequestBody
            @DateTimeFormat(pattern = "MM.yyyy") LocalDate date);
}
