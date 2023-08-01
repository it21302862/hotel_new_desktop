package com.hotel.hotel.repo;

import com.hotel.hotel.entity.HotelContract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelContractRepo extends JpaRepository<HotelContract,Integer> {
}
