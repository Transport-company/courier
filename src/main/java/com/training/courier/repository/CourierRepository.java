package com.training.courier.repository;

import com.training.courier.model.Courier;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

    Boolean existsByPhoneNumber(String phoneNumber);

    @Query(value = "SELECT c FROM Courier c WHERE c.city = ?1 AND c.active = true AND c.tasksNumber = " +
            "(SELECT MIN(c.tasksNumber)  FROM Courier c WHERE c.city = ?1 AND c.active = true)")
    List<Courier> findActiveByCityWithMinimalTasksNumber(String city);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Courier c SET c.tasksNumber = c.tasksNumber + 1 WHERE c = ?1")
    void incrementTasksNumber(Courier courier);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Courier c SET c.tasksNumber = c.tasksNumber + 1 WHERE c = ?1")
    void decrementTasksNumber(Courier courier);
}
