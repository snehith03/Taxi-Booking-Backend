package com.example.tripease.transformer;

import com.example.tripease.dto.request.CabRequest;
import com.example.tripease.dto.response.CabResponse;
import com.example.tripease.dto.response.DriverResponse;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Driver;

public class CabTransformer {

    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .cab_number(cabRequest.getCab_number())
                .cab_model(cabRequest.getCab_model())
                .per_km_rate(cabRequest.getPer_km_rate())
                .available(true)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab, Driver driver){
        return CabResponse.builder()
                .cab_number(cab.getCab_number())
                .cab_model(cab.getCab_model())
                .per_km_rate(cab.getPer_km_rate())
                .available(cab.isAvailable())
                .driver(DriverTransformer.driverToDriverResponse(driver))
                .build();
    }
}
