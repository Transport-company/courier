package com.training.courier.feignClient;

import com.training.courier.dto.request.core.DeliveryInCoreUpdatingRequest;
import com.training.courier.dto.response.DeliveryResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CoreFeignClient",
        url = "${core.deliveriesApi.url}",
        fallback = CoreFeignClientFallback.class)
public interface CoreFeignClient {

    String ID_PATH_VARIABLE = "/{id}";

    @GetMapping(ID_PATH_VARIABLE)
    DeliveryResponse getDeliveryResponse(@PathVariable("id") Long id);

    @GetMapping
    List<DeliveryResponse> getPendingDeliveries(@RequestParam String filter);

    @PatchMapping(ID_PATH_VARIABLE)
    DeliveryResponse updateDelivery(@PathVariable("id") Long id,
                                    @RequestBody DeliveryInCoreUpdatingRequest deliveryInCoreUpdatingRequest);
}
