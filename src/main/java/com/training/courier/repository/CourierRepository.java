package com.training.courier.repository;

import com.training.courier.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

    Boolean existsByPhoneNumber(String phoneNumber);
}
