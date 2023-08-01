package com.hotel.hotel.service;

import com.hotel.hotel.DTO.HotelDTO;
import com.hotel.hotel.entity.Hotel;
import com.hotel.hotel.repo.HotelRepo;
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
public class HotelService {

    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private ModelMapper modelMapper;
    public String saveHotel(HotelDTO hotelDTO){
        if(hotelRepo.existsById(hotelDTO.getHotelID())){
            return VarList.RSP_DUPLICATED;
        }else{
            hotelRepo.save(modelMapper.map(hotelDTO, Hotel.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateHotel(HotelDTO hotelDTO){
        if(hotelRepo.existsById(hotelDTO.getHotelID())){
            hotelRepo.save(modelMapper.map(hotelDTO, Hotel.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<HotelDTO> getAllHotels(){
        List<Hotel> hotelList=hotelRepo.findAll();
        return modelMapper.map(hotelList,new TypeToken<ArrayList<HotelDTO>>(){
        }.getType());
    }

    public HotelDTO searchHotel(int hotelID){
        if(hotelRepo.existsById(hotelID)){
            Hotel hotel=hotelRepo.findById(hotelID).orElse(null);
            return modelMapper.map(hotel,HotelDTO.class);
        }else{
            return null;

        }
    }

    public String deleteHotel(int hotelID){
        if (hotelRepo.existsById(hotelID)){
            hotelRepo.deleteById(hotelID);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
