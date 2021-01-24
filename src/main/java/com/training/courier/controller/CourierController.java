package com.training.courier.controller;

import com.training.courier.Urls;
import com.training.courier.dto.request.SaveCourierRequest;
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

    @GetMapping("/all")
    ResponseEntity<CouriersPageResponse> getAll(Pageable pageable);

    @PostMapping
    ResponseEntity<CourierResponse> create(@RequestBody SaveCourierRequest saveCourierRequest);

    @PutMapping(ID_PATH_VARIABLE)
    ResponseEntity<CourierResponse> update(@PathVariable("id") Long id,
                                           @RequestBody UpdateCourierRequest updateCourierRequest);

    @PostMapping(ID_PATH_VARIABLE)
    ResponseEntity<CourierResponse> delete(@PathVariable("id") Long id); //TODO выяснить, что должен возвращать метод

    @GetMapping(Urls.Courier.Id.Salary.FULL) //TODO сделать правильно
    ResponseEntity<SalaryResponse> getMonthly(@PathVariable("id") Long id); //TODO пока за текущий месяц
}
