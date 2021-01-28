package com.training.courier.controller;

import com.training.courier.Urls;
import com.training.courier.dto.request.CreateCourierRequest;
import com.training.courier.dto.request.UpdateCourierRequest;
import com.training.courier.dto.response.CourierResponse;
import com.training.courier.dto.response.CouriersPageResponse;
import com.training.courier.dto.response.SalaryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Couriers", description = "Courier related interaction endpoints")
public interface CourierController {

    @Operation(summary = "Get information about courier")
//    @ApiResponses()
    @GetMapping(Urls.Courier.Id.FULL)
    ResponseEntity<CourierResponse> getById(@PathVariable("id") Long id);

    @Operation(summary = "Get paged information about all couriers")
    @GetMapping(Urls.Courier.FULL)
    ResponseEntity<CouriersPageResponse> getAll(Pageable pageable);

    @Operation(summary = "Create new courier")
    @PostMapping(Urls.Courier.FULL)
    ResponseEntity<CourierResponse> create(@RequestBody CreateCourierRequest createCourierRequest);

    @Operation(summary = "Edit existing courier information")
    @PutMapping(Urls.Courier.Id.FULL)
    ResponseEntity<CourierResponse> update(@PathVariable("id") Long id,
                                           @RequestBody UpdateCourierRequest updateCourierRequest);

    @Operation(summary = "Delete existing courier")
    @DeleteMapping(Urls.Courier.Id.FULL)
    ResponseEntity<String> delete(@PathVariable("id") Long id);

    @Operation(summary = "Get courier salary for current month")
    @GetMapping(Urls.Courier.Id.Salary.FULL)
    ResponseEntity<SalaryResponse> getMonthly(@PathVariable("id") Long id);
}