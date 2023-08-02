package com.hotel.hotel.DTO;

import com.hotel.hotel.entity.HotelContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SupplementDTO {

    private int supplementID;

    private double price;
    private String supOptions;
    private HotelContract hotelContract;
}
