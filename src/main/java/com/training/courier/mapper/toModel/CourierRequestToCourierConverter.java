package com.training.courier.mapper.toModel;

import com.training.courier.dto.request.CourierRequest;
import com.training.courier.model.Courier;
import org.springframework.core.convert.converter.Converter;

public class CourierRequestToCourierConverter implements Converter<CourierRequest, Courier> {

    @Override
    public Courier convert(CourierRequest request) {
        Courier courier = new Courier();
        courier.setFirstName(request.getFirstName());
        courier.setMiddleName(request.getMiddleName());
        courier.setLastName(request.getLastName());
        courier.setBirthday(request.getBirthday());
        courier.setPhoneNumber(request.getPhoneNumber());
        courier.setCity(request.getCity());

        return courier;
    }
}
