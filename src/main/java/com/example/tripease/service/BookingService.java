package com.example.tripease.service;


import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.response.BookingResponse;
import com.example.tripease.exception.CabNotAvailableException;
import com.example.tripease.exception.CustomerNotFoundException;
import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Customer;
import com.example.tripease.model.Driver;
import com.example.tripease.repository.BookingRepository;
import com.example.tripease.repository.CabRepository;
import com.example.tripease.repository.CustomerRepository;
import com.example.tripease.repository.DriverRepository;
import com.example.tripease.transformer.BookingTransfromer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    DriverRepository driverRepository;
    public BookingResponse bookCab(BookingRequest bookingRequest, int customer_id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customer_id);

        if(optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Invalid Customer");

        Customer customer = optionalCustomer.get();
        Cab availableCab = cabRepository.getAvailableCabRandomly();

        if(availableCab==null)
            throw new CabNotAvailableException("Sorry!! No cabs Available");

        Booking booking = BookingTransfromer.bookingRequestTobooking(bookingRequest, availableCab.getPer_km_rate());
        Booking savedBooking = bookingRepository.save(booking);
        availableCab.setAvailable(false);
        customer.getBookings().add(booking);
        Driver driver = driverRepository.getDriverByCabId(availableCab.getCab_id());
        driver.getBookings().add(booking);

        Customer savedCustomer = customerRepository.save(customer);
        Driver savedDriver = driverRepository.save(driver);

        return BookingTransfromer.bookingToBookingResponse(savedBooking,savedCustomer,availableCab,savedDriver);
    }
}
