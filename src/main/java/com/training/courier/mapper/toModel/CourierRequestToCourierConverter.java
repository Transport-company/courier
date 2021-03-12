package com.training.courier.mapper.toModel;

import com.training.courier.dto.request.CourierRequest;
import com.training.courier.model.Courier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CourierRequestToCourierConverter implements Converter<CourierRequest, Courier> {

    @Override
    public Courier convert(CourierRequest courierRequest) {

        return Courier.builder()
                .firstName(courierRequest.getFirstName())
                .middleName(courierRequest.getMiddleName())
                .lastName(courierRequest.getLastName())
                .birthday(courierRequest.getBirthday())
                .phoneNumber(courierRequest.getPhoneNumber())
                .city(courierRequest.getCity())
                .active(courierRequest.getActive())
                .build();
    }
}
