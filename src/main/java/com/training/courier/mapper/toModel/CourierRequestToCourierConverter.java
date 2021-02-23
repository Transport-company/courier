package com.training.courier.mapper.toModel;

import com.training.courier.dto.request.CourierRequest;
import com.training.courier.model.Courier;
import org.springframework.core.convert.converter.Converter;

public class CourierRequestToCourierConverter implements Converter<CourierRequest, Courier> {

    @Override
    public Courier convert(CourierRequest courierRequest) {
        Courier courier = new Courier();
        courier.setFirstName(courierRequest.getFirstName());
        courier.setMiddleName(courierRequest.getMiddleName());
        courier.setLastName(courierRequest.getLastName());
        courier.setBirthday(courierRequest.getBirthday());
        courier.setPhoneNumber(courierRequest.getPhoneNumber());
        courier.setCity(courierRequest.getCity());
        courier.setIsActive(courierRequest.getIsActive());

        return courier;
    }
}
