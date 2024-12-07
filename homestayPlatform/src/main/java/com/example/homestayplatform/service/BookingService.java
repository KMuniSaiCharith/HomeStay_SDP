package com.example.homestayplatform.service;

import com.example.homestayplatform.model.Booking;
import com.example.homestayplatform.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // Add a new booking
    public Booking addBooking(Booking booking) {
        if (isHomestayAvailable(booking.getHomestay().getId(), booking.getStartDate(), booking.getEndDate())) {
            return bookingRepository.save(booking);
        } else {
            throw new IllegalArgumentException("Homestay is not available for the selected dates");
        }
    }

    // Get bookings for a specific user
    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    // Get bookings for a specific homestay
    public List<Booking> getBookingsByHomestay(Long homestayId) {
        return bookingRepository.findByHomestayId(homestayId);
    }

    // Check if a homestay is available for a given date range
    public boolean isHomestayAvailable(Long homestayId, LocalDate startDate, LocalDate endDate) {
        List<Booking> bookings = bookingRepository.findByHomestayIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                homestayId, endDate, startDate);
        return bookings.isEmpty();
    }
}
