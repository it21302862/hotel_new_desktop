package com.hotel.hotel.DTO;

import com.hotel.hotel.entity.HotelContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomTypeDTO {

    private  int roomtypeID;
    private double roomPrice;
    private int roomCount;
    private int maxAdult;
    private String roomType;
    private HotelContract hotelContract;
}

