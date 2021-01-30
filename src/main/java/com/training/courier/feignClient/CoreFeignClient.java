package com.training.courier.feignClient;

import com.training.courier.dto.request.core.UpdateDeliveryCoreRequest;
import com.training.courier.dto.response.CourierDeliveryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "CoreFeignClient",
        url = "${coreUrl}/deliveries",
        fallback = CoreFeignClientFallback.class)
public interface CoreFeignClient {

    String ID_PATH_VARIABLE = "/{id}";

    @GetMapping
    List<CourierDeliveryResponse> getPendingCourierDeliveries(@RequestParam String filter);

    @PutMapping(ID_PATH_VARIABLE)
    CourierDeliveryResponse updateDelivery(@PathVariable("id") Long id,
            @RequestBody UpdateDeliveryCoreRequest updateDeliveryCoreRequest);
}