package com.example.homestayplatform.controller;

import com.example.homestayplatform.model.Booking;
import com.example.homestayplatform.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create a new booking
    @PostMapping("/add")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        Booking newBooking = bookingService.addBooking(booking);
        return ResponseEntity.ok(newBooking);
    }

    // Get bookings by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.getBookingsByUser(userId);
        return ResponseEntity.ok(bookings);
    }

    // Get bookings by homestay
    @GetMapping("/homestay/{homestayId}")
    public ResponseEntity<List<Booking>> getBookingsByHomestay(@PathVariable Long homestayId) {
        List<Booking> bookings = bookingService.getBookingsByHomestay(homestayId);
        return ResponseEntity.ok(bookings);
    }

    // Check homestay availability
    @GetMapping("/availability/{homestayId}")
    public ResponseEntity<Boolean> checkAvailability(
            @PathVariable Long homestayId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        boolean available = bookingService.isHomestayAvailable(homestayId, startDate, endDate);
        return ResponseEntity.ok(available);
    }
}
