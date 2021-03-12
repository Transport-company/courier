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
    void givenId_whenGetCourierById_thenReturnNotNullCourier() {
        Long id = 1L;

        when(courierRepository.findById(id)).thenReturn(Optional.of(expectedCourier));

        Courier actualCourier = courierService.getById(id);

        assertThat(actualCourier).isNotNull()
                .isEqualTo(expectedCourier);
    }

    @Test
    void givenInvalidId_whenGetCourierById_thenThrowException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.getById(null));
    }

    @Test
    void givenIdOfNonExistingCourier_whenGetCourierById_thenThrowException() {
        Long id = 1L;

        when(courierRepository.findById(id)).thenReturn(Optional.empty());

        assertThatExceptionOfType(CourierNotFoundException.class)
                .isThrownBy(() -> courierService.getById(id));
    }

    @Test
    void givenPageParameters_whenGetAllCouriers_thanReturnNotNullPagedCouriersList() {
        PageRequest pageRequest = PageRequest.of(0, 5);

        when(courierRepository.findAll(pageRequest))
                .thenReturn(new PageImpl<>(expectedCouriersList));

        Page<Courier> actualPage = courierService.getList(pageRequest);

        assertThat(actualPage).isNotNull();
        assertThat(actualPage.getContent()).isNotNull()
                .isEqualTo(expectedCouriersList);
    }

    @Test
    void givenCourier_whenSaveCourier_thenReturnNotNullCourier() {
        when(courierRepository.save(testCourier))
                .thenReturn(expectedCourier);

        Courier actualCourier = courierService.save(testCourier);

        assertThat(actualCourier).isNotNull()
                .isEqualTo(expectedCourier);
    }

    @Test
    void givenInvalidCourier_whenSaveCourier_thenThrowException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.save(null));
    }

    @Test
    void givenAlreadyExistingByPhoneNumberCourier_whenSaveCourier_thenThrowException() {
        when(courierRepository.existsByPhoneNumber(testCourier.getPhoneNumber()))
                .thenReturn(true);

        assertThatExceptionOfType(CourierAlreadyExistsException.class)
                .isThrownBy(() -> courierService.save(testCourier));
    }

    @Test
    void givenIdAndCourier_whenUpdateCourier_thenReturnNotNullCourier() {
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
    void givenInvalidId_whenUpdateCourier_thenThrowException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.update(null, testCourier));
    }

    @Test
    void givenInvalidCourier_whenUpdateCourier_thenThrowException() {
        Long id = 1L;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.update(id, null));
    }

    @Test
    void givenIdOfNonExistingCourier_whenUpdateCourier_thenThrowException() {
        Long id = 1L;

        when(courierRepository.findById(id)).thenReturn(Optional.empty());

        assertThatExceptionOfType(CourierNotFoundException.class)
                .isThrownBy(() -> courierService.update(id, testCourier));
    }

    @Test
    void givenAlreadyExistingByPhoneNumberCourier_whenUpdateCourier_thenThrowException() {
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
    void givenInvalidId_whenDeleteCourier_thenThrowException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.delete(null));
    }

    @Test
    void givenIdOfNonExistingCourier_whenDeleteCourier_thenThrowException() {
        Long id = 1L;

        when(courierRepository.findById(id)).thenReturn(Optional.empty());

        assertThatExceptionOfType(CourierNotFoundException.class)
                .isThrownBy(() -> courierService.delete(id));
    }

    @Test
    void givenCity_whenGetActiveCourierByCityWithMinimalTasksNumber_thenReturnNotNullCourier() {
        String city = "testCity";

        when(courierRepository.findActiveByCityWithMinimalTasksNumber(city))
                .thenReturn(expectedCouriersList);

        Courier actualCourier = courierService.getActiveByCityWithMinimalTasksNumber(city);

        assertThat(actualCourier).isNotNull()
                .isEqualTo(expectedCourier);
    }

    @Test
    void givenInvalidCity_whenGetActiveCourierByCityWithMinimalTasksNumber_thenThrowException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.getActiveByCityWithMinimalTasksNumber(null));
    }

    @Test
    void givenCityWithNotExistingActiveCourier_whenGetActiveCourierByCityWithMinimalTasksNumber_thenThrowException() {
        String city = "testCityWithNotExistingCourier";

        when(courierRepository.findActiveByCityWithMinimalTasksNumber(city))
                .thenThrow(new CourierNotFoundException(city));

        assertThatExceptionOfType(CourierNotFoundException.class)
                .isThrownBy(() -> courierService.getActiveByCityWithMinimalTasksNumber(city));
    }
}
