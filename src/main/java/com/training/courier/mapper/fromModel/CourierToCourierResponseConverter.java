package com.training.courier.mapper.fromModel;

import com.training.courier.dto.response.CourierResponse;
import com.training.courier.model.Courier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CourierToCourierResponseConverter implements Converter<Courier, CourierResponse> {

    @Override
    public CourierResponse convert(Courier courier) {

        return CourierResponse.builder()
                .id(courier.getId())
                .firstName(courier.getFirstName())
                .middleName(courier.getMiddleName())
                .lastName(courier.getLastName())
                .birthday(courier.getBirthday())
                .phoneNumber(courier.getPhoneNumber())
                .city(courier.getCity())
                .active(courier.getActive())
                .tasksNumber(courier.getTasksNumber())
                .created(courier.getCreated())
                .updated(courier.getUpdated())
                .build();
    }
}
