package com.example.homestayplatform.repository;

import com.example.homestayplatform.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Find all bookings made by a specific user
    List<Booking> findByUserId(Long userId);

    // Find all bookings for a specific homestay
    List<Booking> findByHomestayId(Long homestayId);

    // Find all bookings between specific dates (for availability checks)
    List<Booking> findByHomestayIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
        Long homestayId, LocalDate startDate, LocalDate endDate);
}
