package com.hotel.hotel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Markup")

public class Markup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int markupID;

    private double markupPercentage;

    @ManyToOne
    @JoinColumn(name = "hotel_contract_id", nullable = false)
    @NotNull(message = "Hotel Contract is required")
    private HotelContract hotelContract;


}
