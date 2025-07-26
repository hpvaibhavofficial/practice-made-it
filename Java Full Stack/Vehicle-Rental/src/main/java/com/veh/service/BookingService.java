package com.veh.service;

import com.veh.model.Booking;
import com.veh.repo.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Integer id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + id));
    }

    public Booking updateBooking(Integer id, Booking updatedBooking) {
        Booking obj = getBookingById(id);

        obj.setStartDate(updatedBooking.getStartDate());
        obj.setEndDate(updatedBooking.getEndDate());
        obj.setUser(updatedBooking.getUser());
        obj.setVehicle(updatedBooking.getVehicle());

        return bookingRepository.save(obj);
    }

    public void deleteBooking(Integer id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found with ID: " + id);
        }
        bookingRepository.deleteById(id);
    }
}
