package com.training.courier.mapper.fromModel;

import com.training.courier.dto.response.CourierResponse;
import com.training.courier.model.Courier;
import org.springframework.core.convert.converter.Converter;

public class CourierToCourierResponseConverter implements Converter<Courier, CourierResponse> {

    @Override
    public CourierResponse convert(Courier courier) {
        CourierResponse courierResponse = new CourierResponse();
        courierResponse.setId(courier.getId());
        courierResponse.setFirstName(courier.getFirstName());
        courierResponse.setMiddleName(courier.getMiddleName());
        courierResponse.setLastName(courier.getLastName());
        courierResponse.setBirthday(courier.getBirthday());
        courierResponse.setPhoneNumber(courier.getPhoneNumber());
        courierResponse.setCity(courier.getCity());
        courierResponse.setIsActive(courier.getIsActive());
        courierResponse.setActiveTasksNumber(courier.getActiveTasksNumber());
        courierResponse.setCreated(courier.getCreated());
        courierResponse.setUpdated(courier.getUpdated());

        return courierResponse;
    }
}
