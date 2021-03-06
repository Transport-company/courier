package com.training.courier.mapper.fromModel;

import com.training.courier.dto.response.CouriersPagedResponse;
import com.training.courier.model.Courier;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouriersPageToCouriersPagedResponseConverter implements Converter<Page<Courier>, CouriersPagedResponse> {

    private final CourierToCourierResponseConverter courierToCourierResponseConverter;

    @Override
    public CouriersPagedResponse convert(Page<Courier> page) {

        return CouriersPagedResponse.builder()
                .content(
                        page
                                .getContent()
                                .stream()
                                .map(courierToCourierResponseConverter::convert)
                                .collect(Collectors.toList()))
                .pageSize(page.getSize())
                .pageNumber(page.getNumber())
                .totalPages(page.getTotalPages())
                .totalElements(page.getNumberOfElements())
                .build();
    }
}