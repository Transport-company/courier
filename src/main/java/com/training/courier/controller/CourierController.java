package com.training.courier.controller;

import com.training.courier.Urls;
import com.training.courier.dto.request.CreateCourierRequest;
import com.training.courier.dto.request.UpdateCourierRequest;
import com.training.courier.dto.response.CourierResponse;
import com.training.courier.dto.response.CouriersPageResponse;
import com.training.courier.dto.response.SalaryResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Urls.Courier.FULL)
public interface CourierController {

    String ID_PATH_VARIABLE = "/{id}";

    @GetMapping(ID_PATH_VARIABLE)
    ResponseEntity<CourierResponse> getById(@PathVariable("id") Long id);

    @GetMapping
    ResponseEntity<CouriersPageResponse> getAll(Pageable pageable);

    @PostMapping
    ResponseEntity<CourierResponse> create(@RequestBody CreateCourierRequest createCourierRequest);

    @PutMapping(ID_PATH_VARIABLE)
    ResponseEntity<CourierResponse> update(@PathVariable("id") Long id,
                                           @RequestBody UpdateCourierRequest updateCourierRequest);

    @PostMapping(ID_PATH_VARIABLE)
    ResponseEntity<String> delete(@PathVariable("id") Long id);

    @GetMapping(Urls.Courier.Id.Salary.FULL)
    ResponseEntity<SalaryResponse> getMonthly(@PathVariable("id") Long id);
}