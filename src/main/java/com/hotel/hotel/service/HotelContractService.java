package com.hotel.hotel.service;

import com.hotel.hotel.DTO.HotelContractDTO;
import com.hotel.hotel.entity.Hotel;
import com.hotel.hotel.entity.HotelContract;
import com.hotel.hotel.repo.HotelContractRepo;
import com.hotel.hotel.repo.HotelRepo;
import com.hotel.hotel.util.VarList;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class HotelContractService {

    @Autowired
    private HotelContractRepo hotelContractRepo;
    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public HotelContract assignHotelToContract(int contractID, int hotelID) {
        Set<Hotel> hotelSet=null;
        // Fetch the HotelContract and Hotel entities from the database
        Optional<HotelContract> optionalContract = hotelContractRepo.findById(contractID);
        Optional<Hotel> optionalHotel = hotelRepo.findById(hotelID);

        if (optionalContract.isPresent() && optionalHotel.isPresent()) {
            HotelContract contract = optionalContract.get();
            Hotel hotel = optionalHotel.get();

            // Add the Hotel to the HotelContract's hotels set
            hotelSet=contract.getHotels();
            hotelSet.add(hotel);
            contract.setHotels(hotelSet);

            // Save the updated HotelContract to establish the relationship
            return hotelContractRepo.save(contract);
        } else {
            // Handle scenario where either HotelContract or Hotel is not found
            throw new EntityNotFoundException("HotelContract or Hotel not found.");
        }
    }


    public String saveHotelContract(HotelContractDTO hotelContractDTO){
        if(hotelContractRepo.existsById(hotelContractDTO.getContractID())){
            return VarList.RSP_DUPLICATED;
        }else{
            hotelContractRepo.save(modelMapper.map(hotelContractDTO, HotelContract.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateHotelContract(HotelContractDTO hotelContractDTO){
        if(hotelContractRepo.existsById(hotelContractDTO.getContractID())){
            hotelContractRepo.save(modelMapper.map(hotelContractDTO, HotelContract.class));
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<HotelContractDTO> getAllHotelContracts(){
        List<HotelContract> hotelContractList=hotelContractRepo.findAll();
        return modelMapper.map(hotelContractList,new TypeToken<ArrayList<HotelContractDTO>>(){
        }.getType());
    }

    public HotelContractDTO searchHotelContracts(int contractID){
        if(hotelContractRepo.existsById(contractID)){
            HotelContract hotelContract=hotelContractRepo.findById(contractID).orElse(null);
            return modelMapper.map(hotelContract,HotelContractDTO.class);
        }else{
            return null;

        }
    }

    public String deleteHotelContract(int contractID){
        if (hotelContractRepo.existsById(contractID)){
            hotelContractRepo.deleteById(contractID);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}