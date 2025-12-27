package com.example.tripease.dto.response;

import com.example.tripease.Enum.TripStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {
    String pickup;
    String destination;
    double trip_in_km;
    double bill_amount;
    TripStatus trip_status;
    Date booked_at;
    Date last_update_at;

    CustomerResponse customer;
    CabResponse cab;
}
