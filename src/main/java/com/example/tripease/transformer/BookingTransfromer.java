package com.example.tripease.transformer;

import com.example.tripease.Enum.TripStatus;
import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.response.BookingResponse;
import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Customer;
import com.example.tripease.model.Driver;
import com.example.tripease.service.BookingService;

public class BookingTransfromer {
    public static Booking bookingRequestTobooking(BookingRequest bookingRequest, Double per_km_rate){
        return Booking.builder()
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .trip_in_km(bookingRequest.getTrip_in_km())
                .bill_amount(bookingRequest.getTrip_in_km()*per_km_rate)
                .trip_status(TripStatus.ON_GOING)
                .build();

    }


    public static BookingResponse bookingToBookingResponse(Booking booking,
                                                           Customer customer,
                                                           Cab cab,
                                                           Driver driver){
        return BookingResponse.builder()
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .trip_in_km(booking.getTrip_in_km())
                .trip_status(booking.getTrip_status())
                .bill_amount(booking.getBill_amount())
                .booked_at(booking.getBooked_at())
                .last_update_at(booking.getLast_update_at())
                .customer(CustomerTransformer.customerToCustomerResponse(customer))
                .cab(CabTransformer.cabToCabResponse(cab,driver))
                .build();
    }
}
