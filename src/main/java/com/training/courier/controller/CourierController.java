package com.training.courier.controller;

import com.training.courier.Urls;
import com.training.courier.dto.request.CreateCourierRequest;
import com.training.courier.dto.request.UpdateCourierRequest;
import com.training.courier.dto.response.CourierResponse;
import com.training.courier.dto.response.CouriersPageResponse;
import com.training.courier.dto.response.SalaryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Couriers", description = "Courier related interaction endpoints")
@RequestMapping(Urls.Couriers.FULL)
public interface CourierController {

    String ID_PATH_VARIABLE = "/{id}";
    String SALARY = ID_PATH_VARIABLE + "/salary";

    @Operation(summary = "Get information about courier", responses =  {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CourierResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Courier not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping(ID_PATH_VARIABLE)
    ResponseEntity<CourierResponse> getById(@Parameter(name = "id",
                    description = "Courier unique identifier",
                    required = true)
            @PathVariable("id") Long id);

    @Operation(summary = "Get paged information about all couriers", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CouriersPageResponse.class))),
            @ApiResponse(responseCode = "204", description = "No content", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping
    ResponseEntity<CouriersPageResponse> getAll(@Parameter(name = "pageable",
                    description = "Response page parameters",
                    schema = @Schema(implementation = Pageable.class),
                    required = true)
            Pageable pageable);

    @Operation(summary = "Create new courier", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation =  CourierResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping
    ResponseEntity<CourierResponse> create(@Parameter(name = "createCourierRequest",
                    description = "Courier data contained in create request",
                    schema = @Schema(implementation = CreateCourierRequest.class),
                    required = true)
            @RequestBody CreateCourierRequest createCourierRequest);

    @Operation(summary = "Edit existing courier information", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CourierResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Courier not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PutMapping(ID_PATH_VARIABLE)
    ResponseEntity<CourierResponse> update(@Parameter(name = "id",
                    description = "Courier unique identifier",
                    required = true)
            @PathVariable("id") Long id,
            @Parameter(name = "updateCourierRequest",
                    description = "Courier data contained in update request",
                    schema = @Schema(implementation = UpdateCourierRequest.class),
                    required = true)
            @RequestBody UpdateCourierRequest updateCourierRequest);

    @Operation(summary = "Delete existing courier", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Courier not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @DeleteMapping(ID_PATH_VARIABLE)
    ResponseEntity<String> delete(@Parameter(name = "id",
                    description = "Courier unique identifier",
                    required = true)
            @PathVariable("id") Long id);

    @Operation(summary = "Get courier salary for current month", responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = SalaryResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Courier not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping(SALARY)
    ResponseEntity<SalaryResponse> getMonthly(@Parameter(name = "id",
                    description = "Courier unique identifier",
                    required = true)
            @PathVariable("id") Long id);
}