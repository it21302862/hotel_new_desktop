package com.hotel.hotel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SeasonDTO {

    private String seasonName;
    private Date startDate;
    private  Date endDate;
}
