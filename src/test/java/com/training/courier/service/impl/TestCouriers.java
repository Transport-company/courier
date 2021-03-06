package com.training.courier.service.impl;

import com.training.courier.model.Courier;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestCouriers {

    public static Courier testCourier() {

        return Courier.builder()
                .firstName("testCourierFirstName")
                .middleName("testCourierMiddleName")
                .lastName("testCourierLastName")
                .birthday(LocalDate.of(2000, 2, 2))
                .phoneNumber("12345678910")
                .city("testCourierCity")
                .active(true)
                .build();
    }

    public static Courier expectedCourier() {

        return Courier.builder()
                .firstName("testCourierFirstName")
                .middleName("testCourierMiddleName")
                .lastName("testCourierLastName")
                .birthday(LocalDate.of(2000, 2, 2))
                .phoneNumber("12345678910")
                .city("testCourierCity")
                .active(true)
                .id(1L)
                .created(LocalDateTime.of(2020, 1, 1, 1, 1))
                .updated(LocalDateTime.of(2020, 2, 2, 2 , 2))
                .build();
   }

   public static List<Courier> expectedCouriersList() {
       List<Courier> expectedCouriersList = new ArrayList<>();
       expectedCouriersList.add(expectedCourier());

       return expectedCouriersList;
   }
}
