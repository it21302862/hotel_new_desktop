package com.hotel.hotel.repo;

import com.hotel.hotel.entity.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRoomRepo extends JpaRepository<HotelRoom,Integer> {
}
