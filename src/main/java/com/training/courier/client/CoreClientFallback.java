package com.training.courier.client;

import com.training.courier.dto.request.UpdateDeliveryRequest;
import com.training.courier.dto.response.DeliveryResponse;

import java.util.ArrayList;
import java.util.List;

class CoreClientFallback implements CoreClient {

    @Override
    public List<DeliveryResponse> getPendingCourierDeliveries() {
        return new ArrayList<DeliveryResponse>();
    }

    @Override
    public DeliveryResponse updateDelivery(Long id, UpdateDeliveryRequest updateDeliveryRequest) {
        return null;
    }
}
