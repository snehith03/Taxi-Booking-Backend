package com.example.tripease.transformer;

import com.example.tripease.dto.request.DriverRequest;
import com.example.tripease.dto.response.DriverResponse;
import com.example.tripease.model.Driver;

public class DriverTransformer {

    public static Driver driverRequestToDriver(DriverRequest driverRequest){
        return Driver.builder().
                name(driverRequest.getName()).
                age(driverRequest.getAge()).
                email_id(driverRequest.getEmail_id()).build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                .driver_id(driver.getDriver_id())
                .name(driver.getName())
                .age(driver.getAge())
                .email_id(driver.getEmail_id())
                .build();
    }
}
