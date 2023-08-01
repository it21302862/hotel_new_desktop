package com.hotel.hotel.DTO;

import com.hotel.hotel.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelRoomDTO {
    private int hotelRoomID;
    private String roomNumber;
    private Hotel hotel;
    private String roomType;
    private double price;

    private boolean available;
}
