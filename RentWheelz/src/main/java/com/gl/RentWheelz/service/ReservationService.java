package com.gl.RentWheelz.service;

import com.gl.RentWheelz.model.Reservation;
import com.gl.RentWheelz.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    // auto-wire the reservation repository
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> findByUserEmail(String userEmail) {
        return reservationRepository.findByUserEmail(userEmail);
    }

    public Optional<Reservation> findById(Long bookingId) {
        return reservationRepository.findById(bookingId);
    }

   public void updateStatus(Long bookingId, String status) {
        reservationRepository.updateStatus(bookingId, status);
    }
}
