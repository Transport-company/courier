package com.training.courier.service.impl;

import com.training.courier.exception.CourierAlreadyExistsException;
import com.training.courier.exception.CourierNotFoundException;
import com.training.courier.model.Courier;
import com.training.courier.repository.CourierRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Data;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

@Data
public class CourierServiceImplTest {

    @InjectMocks
    private CourierServiceImpl courierService;

    @Mock
    CourierRepository courierRepository;

    private static Courier testCourier;
    private static Courier expectedCourier;
    private static List<Courier> expectedCouriers;

    @BeforeAll
    private static void prepareTestData() {
        testCourier = new Courier();
        testCourier.setFirstName("FirstNameTest");
        testCourier.setMiddleName("MiddleNameTest");
        testCourier.setLastName("LastNameTest");
        testCourier.setBirthday(LocalDate.of(2000, 02, 02));
        testCourier.setPhoneNumber("12345678910");
        testCourier.setCity("CityTest");

        expectedCourier = new Courier();
        expectedCourier.setId(1L);
        expectedCourier.setFirstName(testCourier.getFirstName());
        expectedCourier.setMiddleName(testCourier.getMiddleName());
        expectedCourier.setLastName(testCourier.getLastName());
        expectedCourier.setBirthday(testCourier.getBirthday());
        expectedCourier.setPhoneNumber(testCourier.getPhoneNumber());
        expectedCourier.setCity(testCourier.getCity());
        expectedCourier.setCreated(LocalDateTime.of(2020, 01, 01, 01, 01));
        expectedCourier.setUpdated(LocalDateTime.of(2020, 02, 02, 02, 02));

        expectedCouriers = new ArrayList<>();
        expectedCouriers.add(expectedCourier);
    }

    @BeforeEach
    void init() {
        openMocks(this);
    }

    @Test
    void getByIdTest() {
        Long id = 1L;

        when(courierRepository.findById(id)).thenReturn(Optional.of(expectedCourier));

        Courier actualCourier = courierService.getById(id);

        assertThat(actualCourier).isNotNull()
                .isEqualTo(expectedCourier);
    }

    @Test
    void getByIdThrowsIllegalArgumentExceptionTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.getById(null));
    }

    @Test
    void getByIdThrowsCourierNotFoundException() {
        Long id = 1L;

        when(courierRepository.findById(id)).thenReturn(Optional.empty());

        assertThatExceptionOfType(CourierNotFoundException.class)
                .isThrownBy(() -> courierService.getById(id));
    }


    @Test
    void getAllTest() {
        PageRequest pageRequest = PageRequest.of(0, 5);

        when(courierRepository.findAll(pageRequest))
                .thenReturn(new PageImpl<>(expectedCouriers));

        Page<Courier> actualPage = courierService.getAll(pageRequest);

        assertThat(actualPage).isNotNull();
        assertThat(actualPage.getContent()).isNotNull()
                .isEqualTo(expectedCouriers);
    }

    @Test
    void saveTest() {
        when(courierRepository.save(testCourier))
                .thenReturn(expectedCourier);

        Courier actualCourier = courierService.save(testCourier);

        assertThat(actualCourier).isNotNull()
                .isEqualTo(expectedCourier);
    }

    @Test
    void saveThrowsIllegalArgumentExceptionTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.save(null));
    }

    @Test
    void saveThrowsCourierAlreadyExistsExceptionTest() {
        when(courierRepository.existsByPhoneNumber(testCourier.getPhoneNumber()))
                .thenReturn(true);

        assertThatExceptionOfType(CourierAlreadyExistsException.class)
                .isThrownBy(() -> courierService.save(testCourier));
    }

    @Test
    void updateTest() {
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
    void updateThrowsIllegalArgumentExceptionWhenIdIsNullTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.update(null, testCourier));
    }

    @Test
    void updateThrowsIllegalArgumentExceptionWhenCourierIsNullTest() {
        Long id = 1L;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.update(id, null));
    }

    @Test
    void updateThrowsCourierAlreadyExistsExceptionTest() {
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
    void deleteThrowsIllegalArgumentExceptionTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> courierService.delete(null));
    }

    @Test
    void deleteThrowsCourierNotFoundException() {
        Long id = 1L;

        when(courierRepository.findById(id)).thenReturn(Optional.empty());

        assertThatExceptionOfType(CourierNotFoundException.class)
                .isThrownBy(() -> courierService.delete(id));
    }
}
