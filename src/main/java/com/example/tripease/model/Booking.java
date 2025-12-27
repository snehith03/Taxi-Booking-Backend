package com.example.tripease.model;


import com.example.tripease.Enum.TripStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int booking_id;
     String pickup;
     String destination;
     double trip_in_km;
     double bill_amount;
     TripStatus trip_status;

     @CreationTimestamp
     Date booked_at;

     @UpdateTimestamp
    Date last_update_at;


}
