package com.hotel.hotel.DTO;

import com.hotel.hotel.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelContractDTO {

    private int contractID;
    private Date startDate;
    private Date endDate;
    private String termsAndConditions;

}
