package com.training.courier.repository;

import com.training.courier.model.Courier;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

    Boolean existsByPhoneNumber(String phoneNumber);

    @Query(value = "SELECT c FROM Courier c WHERE c.city = ?1 AND c.isActive = true AND c.activeTasksNumber = " +
            "(SELECT MIN(c.activeTasksNumber)  FROM Courier c WHERE c.city = ?1 AND c.isActive = true)")
    List<Courier> findActiveByCityWithMinimalActiveTasks(String city);
}
