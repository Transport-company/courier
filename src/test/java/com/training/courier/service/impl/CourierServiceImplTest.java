package com.training.courier.service.impl;

import com.training.courier.exception.CourierAlreadyExistsException;
import com.training.courier.exception.CourierNotFoundException;
import com.training.courier.model.Courier;
import com.training.courier.repository.CourierRepository;
import java.util.List;
import java.util.Optional;
import lombok.Data;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

@Data
public class CourierServiceImplTest extends BaseTest{

    @InjectMocks
    private CourierServiceImpl courierService;

    @Mock
    CourierRepository courierRepository;

    private static Courier testCourier;
    private static Courier expectedCourier;
    private static List<Courier> expectedCouriersList;

    @BeforeAll
    private static void prepareTestData() {
        testCourier = TestCouriers.testCourier();
        expectedCourier = TestCouriers.expectedCourier();
        expectedCouriersList = TestCouriers.expectedCouriersList();
    }

    @Test
    void given_id_when_getCourierById_then_returnNotNullCourier() {
        Long id = 1L;

        when(courierRepository.findById(id)).thenReturn(Optional.of(expectedCourier));

        Courier actualCourier = courierService.getById(id);

        assertThat(actualCourier).isNotNull()
                .isEqualTo(expectedCourier);
    }

    @Test
    void given_invalidId_when_getCourierById_then_throwException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.getById(null));
    }

    @Test
    void given_idOfNonExistingCourier_when_getCourierById_then_throwException() {
        Long id = 1L;

        when(courierRepository.findById(id)).thenReturn(Optional.empty());

        assertThatExceptionOfType(CourierNotFoundException.class)
                .isThrownBy(() -> courierService.getById(id));
    }

    @Test
    void given_pageParameters_when_getAllCouriers_than_returnNotNullPagedCouriersList() {
        PageRequest pageRequest = PageRequest.of(0, 5);

        when(courierRepository.findAll(pageRequest))
                .thenReturn(new PageImpl<>(expectedCouriersList));

        Page<Courier> actualPage = courierService.getList(pageRequest);

        assertThat(actualPage).isNotNull();
        assertThat(actualPage.getContent()).isNotNull()
                .isEqualTo(expectedCouriersList);
    }

    @Test
    void given_courier_when_saveCourier_then_returnNotNullCourier() {
        when(courierRepository.save(testCourier))
                .thenReturn(expectedCourier);

        Courier actualCourier = courierService.save(testCourier);

        assertThat(actualCourier).isNotNull()
                .isEqualTo(expectedCourier);
    }

    @Test
    void given_invalidCourier_when_saveCourier_then_throwException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.save(null));
    }

    @Test
    void given_alreadyExistingByPhoneNumberCourier_when_saveCourier_then_throwException() {
        when(courierRepository.existsByPhoneNumber(testCourier.getPhoneNumber()))
                .thenReturn(true);

        assertThatExceptionOfType(CourierAlreadyExistsException.class)
                .isThrownBy(() -> courierService.save(testCourier));
    }

    @Test
    void given_idAndCourier_when_updateCourier_then_returnNotNullCourier() {
        Long id = 1L;

        when(courierRepository.findById(id))
                .thenReturn(Optional.of(expectedCourier));

        when(courierRepository.save(testCourier))
                .thenReturn(expectedCourier);

        Courier actualCourier = courierService.update(id, testCourier);

        assertThat(actualCourier).isNotNull()
                .isEqualTo(expectedCourier);
    }

    @Test
    void given_invalidId_when_updateCourier_then_throwException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.update(null, testCourier));
    }

    @Test
    void given_invalidCourier_when_updateCourier_then_throwException() {
        Long id = 1L;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.update(id, null));
    }

    @Test
    void given_idOfNonExistingCourier_when_updateCourier_then_throwException() {
        Long id = 1L;

        when(courierRepository.findById(id)).thenReturn(Optional.empty());

        assertThatExceptionOfType(CourierNotFoundException.class)
                .isThrownBy(() -> courierService.update(id, testCourier));
    }

    @Test
    void given_alreadyExistingByPhoneNumberCourier_when_updateCourier_then_throwException() {
        Long id = 1L;
        testCourier.setPhoneNumber("12345678911");

        when(courierRepository.findById(id))
                .thenReturn(Optional.of(expectedCourier));
        when(courierRepository.existsByPhoneNumber(testCourier.getPhoneNumber()))
                .thenReturn(true);

        assertThatExceptionOfType(CourierAlreadyExistsException.class)
                .isThrownBy(() -> courierService.update(id, testCourier));
    }

    @Test
    void given_invalidId_when_deleteCourier_then_throwException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.delete(null));
    }

    @Test
    void given_idOfNonExistingCourier_when_deleteCourier_then_throwException() {
        Long id = 1L;

        when(courierRepository.findById(id)).thenReturn(Optional.empty());

        assertThatExceptionOfType(CourierNotFoundException.class)
                .isThrownBy(() -> courierService.delete(id));
    }

    @Test
    void given_city_when_getActiveCourierByCityWithMinimalTasksNumber_then_returnNotNullCourier() {
        String city = "testCity";

        when(courierRepository.findActiveByCityWithMinimalTasksNumber(city))
                .thenReturn(expectedCouriersList);

        Courier actualCourier = courierService.getActiveByCityWithMinimalTasksNumber(city);

        assertThat(actualCourier).isNotNull()
                .isEqualTo(expectedCourier);
    }

    @Test
    void given_invalidCity_when_getActiveCourierByCityWithMinimalTasksNumber_then_throwException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.getActiveByCityWithMinimalTasksNumber(null));
    }

    @Test
    void given_cityWithNotExistingActiveCourier_when_getActiveCourierByCityWithMinimalTasksNumber_then_throwException() {
        String city = "testCityWithNotExistingCourier";

        when(courierRepository.findActiveByCityWithMinimalTasksNumber(city))
                .thenThrow(new CourierNotFoundException(city));

        assertThatExceptionOfType(CourierNotFoundException.class)
                .isThrownBy(() -> courierService.getActiveByCityWithMinimalTasksNumber(city));
    }
}
