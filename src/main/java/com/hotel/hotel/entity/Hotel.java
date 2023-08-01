package com.hotel.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int hotelID;

    @NotBlank(message="You should need to give a name to the hotel")
    private String hotelName;

    @NotBlank(message = "Address cannot be null please give the location")
    private String hotelAddress;

    @Column(unique = true)
    @NotBlank(message="Email address cannot be null")
    @Email(message="Invalid Email Address!Please try again!")
    private String hotelEmail;

    @NotBlank(message = "Contact information cannot be blank")
    @Pattern(regexp = "\\+?[0-9]{10}+",message = "Invalid Phone Number!Please Try Again!")

    private String hotelPhoneNumber;

    @JsonIgnore
    @ManyToMany(mappedBy = "hotels")
    private Set<HotelContract> hotelContracts=new HashSet<>();

}
