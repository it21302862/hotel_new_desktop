package com.hotel.hotel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Season")

public class Season {

    @Id
    @NotBlank(message = "Season name must not be blank")
    private String seasonName;

    @NotNull(message = "Start date must not be null")
    private Date startDate;

    @NotNull(message = "End date must not be null")
    private Date endDate;
}
