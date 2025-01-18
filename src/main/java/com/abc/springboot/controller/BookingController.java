package com.abc.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.abc.springboot.entity.Booking;
import com.abc.springboot.service.BookingService;
import com.abc.springboot.service.ClassService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ClassService classService;

    @PostMapping
    public ResponseEntity<String> createBooking(@RequestBody Booking booking) {
        bookingService.createBooking(booking, classService.getClasses());
        return ResponseEntity.status(201).body("Booking created successfully.");
    }

    @GetMapping
    public ResponseEntity<List<Booking>> searchBookings(
            @RequestParam(required = false) String memberName,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {
        return ResponseEntity.ok(bookingService.searchBookings(memberName, startDate, endDate));
    }
}

