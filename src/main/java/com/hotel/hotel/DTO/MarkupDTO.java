package com.hotel.hotel.DTO;

import com.hotel.hotel.entity.HotelContract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarkupDTO {

    private int markupID;
    private double markupPercentage;
    private HotelContract hotelContract;
}
