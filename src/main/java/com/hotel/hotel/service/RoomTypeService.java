package com.hotel.hotel.service;


import com.hotel.hotel.DTO.RoomTypeDTO;
import com.hotel.hotel.entity.RoomType;
import com.hotel.hotel.repo.RoomTypeRepo;
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
public class RoomTypeService {

    @Autowired
    private RoomTypeRepo roomTypeRepo;

    @Autowired
    private ModelMapper modelMapper;


    //save hotel room type
    public String saveRoomType(RoomTypeDTO roomTypeDTO){

        if(roomTypeRepo.existsById(roomTypeDTO.getRoomtypeID())){

            return VarList.RSP_DUPLICATED;
        }
        else{

            roomTypeRepo.save(modelMapper.map(roomTypeDTO, RoomType.class));
            return VarList.RSP_SUCCESS;
        }
    }


    //update hotel room type

    public String updateRoomType(RoomTypeDTO roomTypeDTO){

        if(roomTypeRepo.existsById(roomTypeDTO.getRoomtypeID())){

            roomTypeRepo.save(modelMapper.map(roomTypeDTO,RoomType.class));

            return VarList.RSP_SUCCESS;

        }
        else {

            return VarList.RSP_NO_DATA_FOUND;
        }
    }


    // view all hotel rooms types
    public List<RoomTypeDTO> getAllRoomTypes(){

        List<RoomType> RoomTypeList = roomTypeRepo.findAll();
        return modelMapper.map(RoomTypeList,new TypeToken<ArrayList<RoomTypeDTO>>(){

        }.getType());
    }


    //Search hotel
    public RoomTypeDTO searchRoomType(int roomTypeNO ){
        if(roomTypeRepo.existsById(roomTypeNO)){

            RoomType roomType = roomTypeRepo.findById(roomTypeNO).orElse(null);
            return modelMapper.map(roomType,RoomTypeDTO.class);
        }

        else{
            return  null;
        }
    }


    //Delete hotel room type
    public String deleteRoomType(int roomTypeNo){
        if (roomTypeRepo.existsById(roomTypeNo)){
            roomTypeRepo.deleteById(roomTypeNo);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }


}

