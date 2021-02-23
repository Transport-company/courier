package com.training.courier.mapper.fromModel;

import com.training.courier.dto.response.CouriersPagedResponse;
import com.training.courier.model.Courier;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

@RequiredArgsConstructor
public class CouriersPageToCouriersPagedResponseConverter implements Converter<Page<Courier>, CouriersPagedResponse> {

    private final CourierToCourierResponseConverter courierToCourierResponseConverter;

    @Override
    public CouriersPagedResponse convert(Page<Courier> page) {
        CouriersPagedResponse couriersPagedResponse = new CouriersPagedResponse();

        couriersPagedResponse.setContent(page.getContent()
                .stream()
                .map(courierToCourierResponseConverter::convert)
                .collect(Collectors.toList()));
        couriersPagedResponse.setPageSize(page.getSize());
        couriersPagedResponse.setPageNumber(page.getNumber());
        couriersPagedResponse.setPageNumber(page.getTotalPages());
        couriersPagedResponse.setTotalElements(page.getNumberOfElements());

        return couriersPagedResponse;
    }
}