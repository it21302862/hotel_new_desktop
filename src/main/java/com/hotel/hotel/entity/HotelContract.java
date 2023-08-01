package com.hotel.hotel.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Hotel_Contract")
public class HotelContract {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractID;

    //@NotNull(message = "Start date is required")
    private Date startDate;

    //@NotNull(message = "End date is required")
    private Date endDate;

    //@NotNull(message = "Terms and conditions are required")
    @Column(length = 1000)
    private String termsAndConditions;



    @ManyToMany
    @JoinTable(
            name = "hotel_contract_mapping",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "hotel_id")
    )

  private  Set<Hotel> hotels=new HashSet<>();




}
