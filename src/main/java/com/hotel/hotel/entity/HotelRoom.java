package com.hotel.hotel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Hotel_Room")

public class HotelRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelRoomID;

    @NotBlank(message = "Room number is required")
    @Column(unique = true)
    private String roomNumber;

//    @ManyToOne
//    @JoinColumn(name = "room_type_id", nullable = false)
//    @NotNull(message = "Room type is required")
//    private RoomType roomType;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    @NotNull(message = "Hotel is required")
    private Hotel hotel;

    private String roomType;

    @Positive(message = "Price must be a positive value")
    private double price;

    private boolean available;



}
