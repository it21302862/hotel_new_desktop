package com.hotel.hotel.entity;

import jakarta.persistence.*;
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


}
