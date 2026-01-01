package com.gl.RentWheelz.repository;

import com.gl.RentWheelz.model.Reservation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserEmail(String userEmail);

    // add a method to update the status of a reservation
    // add a JPA query to update the status of a reservation
    @Transactional
    @Modifying
    @Query("update Reservation r set r.status = :status where r.bookingId = :bookingId")
    void updateStatus(Long bookingId, String status);
}
