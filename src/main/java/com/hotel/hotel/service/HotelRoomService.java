package com.hotel.hotel.service;


import com.hotel.hotel.DTO.HotelDTO;
import com.hotel.hotel.DTO.HotelRoomDTO;
import com.hotel.hotel.entity.Hotel;
import com.hotel.hotel.entity.HotelRoom;
import com.hotel.hotel.repo.HotelRoomRepo;
import com.hotel.hotel.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HotelRoomService {

    @Autowired
    private HotelRoomRepo hotelRoomRepo;
    @Autowired
    private ModelMapper modelMapper;

    public String saveHotelRoom(HotelRoomDTO hotelRoomDTO){
        if(hotelRoomRepo.existsById(hotelRoomDTO.getHotelRoomID())){
            return VarList.RSP_DUPLICATED;
        }else{
            hotelRoomRepo.save(modelMapper.map(hotelRoomDTO, HotelRoom.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateHotelRoom(HotelRoomDTO hotelRoomDTO){
        if(hotelRoomRepo.existsById(hotelRoomDTO.getHotelRoomID())){
            hotelRoomRepo.save(modelMapper.map(hotelRoomDTO, HotelRoom.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<HotelRoomDTO> getAllHotelRooms(){
        List<HotelRoom> hotelList=hotelRoomRepo.findAll();
        return modelMapper.map(hotelList,new TypeToken<ArrayList<HotelRoomDTO>>(){
        }.getType());
    }

    public HotelRoomDTO searchHotelRoom(int hotelRoomID){
        if(hotelRoomRepo.existsById(hotelRoomID)){
            HotelRoom hotelRoom=hotelRoomRepo.findById(hotelRoomID).orElse(null);
            return modelMapper.map(hotelRoom,HotelRoomDTO.class);
        }else{
            return null;

        }
    }

    public String deleteHotelRoom(int hotelRoomID){
        if (hotelRoomRepo.existsById(hotelRoomID)){
            hotelRoomRepo.deleteById(hotelRoomID);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
