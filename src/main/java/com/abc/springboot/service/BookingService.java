package com.abc.springboot.service;

import org.springframework.stereotype.Service;

import com.abc.springboot.entity.Booking;
import com.abc.springboot.entity.ClassEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    private final List<Booking> bookings = new ArrayList<>();

    public void createBooking(Booking booking, List<ClassEntity> classes) {
        if (booking.getParticipationDate().isBefore(LocalDate.now())) {
          throw new IllegalArgumentException("Participation date must be in the future.");
        }

        ClassEntity classToBook = classes.stream()
                .filter(c -> c.getName().equals(booking.getClassName()) && 
                		booking.getParticipationDate().isAfter(c.getStartDate().minusDays(1)) &&
                		booking.getParticipationDate().isBefore(c.getEndDate().plusDays(1)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Class not found for the specified date."));
        
        long bookingCount = bookings.stream()
                .filter(b -> b.getClassName().equals(booking.getClassName()) && b.getParticipationDate().equals(booking.getParticipationDate()))
                .count();
        
        if (bookingCount >= classToBook.getCapacity()) {
            throw new IllegalArgumentException("Class capacity exceeded for the selected date.");
        }

        bookings.add(booking);
    }

    public List<Booking> searchBookings(String memberName, LocalDate startDate, LocalDate endDate) {
        return bookings.stream()
                .filter(b -> (memberName == null || b.getMemberName().equalsIgnoreCase(memberName)) &&
                        (startDate == null || !b.getParticipationDate().isBefore(startDate)) &&
                        (endDate == null || !b.getParticipationDate().isAfter(endDate)))
                .collect(Collectors.toList());
    }
}

