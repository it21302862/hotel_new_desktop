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
@Table(name="supplement")
public class Supplement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplementID;

    private double price;
    private String supOptions;

    @ManyToOne
    @JoinColumn(name = "hotel_contract_id", nullable = false)
    @NotNull(message = "Hotel Contract is required")
    private HotelContract hotelContract;

}
