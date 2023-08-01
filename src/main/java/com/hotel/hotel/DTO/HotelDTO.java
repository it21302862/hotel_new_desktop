package com.hotel.hotel.DTO;

import com.hotel.hotel.entity.HotelContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO {

    private int hotelID;
    private String hotelName;
    private String hotelAddress;
    private String hotelEmail;
    private String hotelPhoneNumber;
}
