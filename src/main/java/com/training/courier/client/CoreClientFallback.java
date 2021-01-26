package com.training.courier.client;

import com.training.courier.dto.request.UpdateDeliveryRequest;
import com.training.courier.dto.response.CourierDeliveryResponse;

import java.util.ArrayList;
import java.util.List;

class CoreClientFallback implements CoreClient {

    @Override
    public List<CourierDeliveryResponse> getPendingCourierDeliveries() {
        return new ArrayList<CourierDeliveryResponse>();
    }

    @Override
    public CourierDeliveryResponse updateDelivery(Long id, UpdateDeliveryRequest updateDeliveryRequest) {
        return null;
    }
}